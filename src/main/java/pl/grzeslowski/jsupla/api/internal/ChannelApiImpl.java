package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.ChannelGroupsApi;
import io.swagger.client.api.ChannelsApi;
import io.swagger.client.api.IoDevicesApi;
import io.swagger.client.model.ChannelExecuteActionRequest;
import io.swagger.client.model.ChannelFunctionActionEnum;
import pl.grzeslowski.jsupla.api.ChannelApi;
import pl.grzeslowski.jsupla.api.ChannelGroupApi;
import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.channel.action.Action;
import pl.grzeslowski.jsupla.api.channel.action.OpenCloseAction;
import pl.grzeslowski.jsupla.api.channel.action.SetBrightnessAction;
import pl.grzeslowski.jsupla.api.channel.action.SetBrightnessAndColor;
import pl.grzeslowski.jsupla.api.channel.action.SetColorAction;
import pl.grzeslowski.jsupla.api.channel.action.ShutRevealAction;
import pl.grzeslowski.jsupla.api.channel.action.StopAction;
import pl.grzeslowski.jsupla.api.channel.action.ToggleAction;
import pl.grzeslowski.jsupla.api.channel.action.TurnOnOffAction;
import pl.grzeslowski.jsupla.api.channelgroup.ChannelGroup;
import pl.grzeslowski.jsupla.api.device.Device;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static io.swagger.client.model.ChannelFunctionActionEnum.OPEN_CLOSE;
import static io.swagger.client.model.ChannelFunctionActionEnum.SET_RGBW_PARAMETERS;
import static io.swagger.client.model.ChannelFunctionActionEnum.SHUT;
import static io.swagger.client.model.ChannelFunctionActionEnum.STOP;
import static io.swagger.client.model.ChannelFunctionActionEnum.TURN_OFF;
import static io.swagger.client.model.ChannelFunctionActionEnum.TURN_ON;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;
import static pl.grzeslowski.jsupla.api.internal.ChannelDispatcher.INSTANCE;

final class ChannelApiImpl implements ChannelApi, ChannelGroupApi {
    private static final List<String> DEFAULT_INCLUDE = asList("connected", "state");
    private static final List<String> CHANNEL_GROUP_DEFAULT_INCLUDE = singletonList("channels");
    private final ChannelsApi channelsApi;
    private final ChannelGroupsApi channelGroupsApi;
    private final IoDevicesApi ioDevicesApi;

    ChannelApiImpl(final ApiClient apiClient) {
        channelsApi = new ChannelsApi(apiClient);
        channelGroupsApi = new ChannelGroupsApi(apiClient);
        ioDevicesApi = new IoDevicesApi(apiClient);
    }

    @Override
    public Channel findChannel(final int id) {
        try {
            return mapToChannel(channelsApi.getChannel(id, DEFAULT_INCLUDE));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findChannel/" + id, e);
        }
    }

    @Override
    public SortedSet<Channel> findChannels() {
        try {
            return channelsApi.getChannels(DEFAULT_INCLUDE, null, null, null)
                           .stream()
                           .map(this::mapToChannel)
                           .collect(Collectors.toCollection(TreeSet::new));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findChannels", e);
        }
    }

    @Override
    public SortedSet<Channel> findChannels(final Device device) {
        try {
            return ioDevicesApi.getIoDeviceChannels(device.getId(), singletonList("location"))
                           .stream()
                           .map(this::mapToChannel)
                           .collect(Collectors.toCollection(TreeSet::new));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findChannels/" + device.getId(), e);
        }
    }

    private Channel mapToChannel(io.swagger.client.model.Channel channel) {
        return ChannelFunctionDispatcher.DISPATCHER.dispatch(channel, INSTANCE);
    }

    @Override
    public Supplier<Channel> updateState(final Channel channel, final Action action) {
        final ChannelExecuteActionRequest body = buildChannelExecuteActionRequest(action);
        try {
            channelsApi.executeAction(body, channel.getId());
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/updateState/" + channel.getId() + "/" + action + " (Channel)", e);
        }
        return memoize(() -> findChannel(channel.getId()));
    }

    @Override
    public void updateState(final ChannelGroup channelGroup, final Action action) {
        final ChannelExecuteActionRequest body = buildChannelExecuteActionRequest(action);
        try {
            channelGroupsApi.executeChannelGroupAction(body, channelGroup.getId());
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/updateState/" + channelGroup.getId() + "/" + action + " (ChannelGroup)", e);
        }
    }

    private ChannelExecuteActionRequest buildChannelExecuteActionRequest(final Action action) {
        if (action == OpenCloseAction.OPEN) {
            return new ChannelExecuteActionRequest().action(ChannelFunctionActionEnum.OPEN);
        } else if (action == OpenCloseAction.CLOSE) {
            return new ChannelExecuteActionRequest().action(ChannelFunctionActionEnum.CLOSE);
        } else if (action instanceof SetBrightnessAction) {
            final SetBrightnessAction brightnessAction = (SetBrightnessAction) action;
            return new ChannelExecuteActionRequest().action(SET_RGBW_PARAMETERS).brightness(brightnessAction.getBrightness());
        } else if (action instanceof SetBrightnessAndColor) {
            final SetBrightnessAndColor brightnessAndColor = (SetBrightnessAndColor) action;
            HsbTypeConverter.CloudFormat cloudFormat = HsbTypeConverter.INSTANCE.toCloudFormat(brightnessAndColor.getRgb());
            return new ChannelExecuteActionRequest().action(SET_RGBW_PARAMETERS)
                           .color(cloudFormat.getColor())
                           .colorBrightness(cloudFormat.getColorBrightness())
                           .brightness(brightnessAndColor.getBrightness());
        } else if (action instanceof SetColorAction) {
            final SetColorAction colorAction = (SetColorAction) action;
            HsbTypeConverter.CloudFormat cloudFormat = HsbTypeConverter.INSTANCE.toCloudFormat(colorAction.getRgb());
            return new ChannelExecuteActionRequest().action(SET_RGBW_PARAMETERS)
                           .color(cloudFormat.getColor())
                           .colorBrightness(cloudFormat.getColorBrightness());
        } else if (action instanceof ShutRevealAction) {
            final ShutRevealAction shutRevealAction = (ShutRevealAction) action;
            return new ChannelExecuteActionRequest().action(SHUT).percentage(shutRevealAction.getShut());
        } else if (action == StopAction.STOP) {
            return new ChannelExecuteActionRequest().action(STOP);
        } else if (action == ToggleAction.OPEN_CLOSE) {
            return new ChannelExecuteActionRequest().action(OPEN_CLOSE);
        } else if (action == TurnOnOffAction.ON) {
            return new ChannelExecuteActionRequest().action(TURN_ON);
        } else if (action == TurnOnOffAction.OFF) {
            return new ChannelExecuteActionRequest().action(TURN_OFF);
        }
        throw new IllegalArgumentException("Do not know how to map this action " + action);
    }

    // https://stackoverflow.com/a/35332514/1819402
    private static <T> Supplier<T> memoize(Supplier<T> delegate) {
        AtomicReference<T> value = new AtomicReference<>();
        return () -> {
            T val = value.get();
            if (val == null) {
                val = value.updateAndGet(cur -> cur == null ? requireNonNull(delegate.get()) : cur);
            }
            return val;
        };
    }

    @Override
    public ChannelGroup findChannelGroup(final int id) {
        try {
            return new ChannelGroupImpl(channelGroupsApi.getChannelGroup(id, CHANNEL_GROUP_DEFAULT_INCLUDE));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findChannelGroup/" + id, e);
        }
    }

    @Override
    public SortedSet<ChannelGroup> findChannelGroups() {
        try {
            return channelGroupsApi.getChannelGroups(CHANNEL_GROUP_DEFAULT_INCLUDE)
                           .stream()
                           .map(ChannelGroupImpl::new)
                           .collect(Collectors.toCollection(TreeSet::new));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findChannelGroups/", e);
        }
    }
}
