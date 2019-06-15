package pl.grzeslowski.jsupla.api.internal;

import pl.grzeslowski.jsupla.api.ChannelApi;
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
import pl.grzeslowski.jsupla.api.device.Device;
import pl.grzeslowski.jsupla.api.generated.ApiClient;
import pl.grzeslowski.jsupla.api.generated.ApiException;
import pl.grzeslowski.jsupla.api.generated.api.ChannelsApi;
import pl.grzeslowski.jsupla.api.generated.api.IoDevicesApi;
import pl.grzeslowski.jsupla.api.generated.model.ChannelExecuteActionRequest;
import pl.grzeslowski.jsupla.api.generated.model.ChannelFunctionActionEnum;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;
import static pl.grzeslowski.jsupla.api.generated.model.ChannelFunctionActionEnum.OPEN_CLOSE;
import static pl.grzeslowski.jsupla.api.generated.model.ChannelFunctionActionEnum.SET_RGBW_PARAMETERS;
import static pl.grzeslowski.jsupla.api.generated.model.ChannelFunctionActionEnum.SHUT;
import static pl.grzeslowski.jsupla.api.generated.model.ChannelFunctionActionEnum.STOP;
import static pl.grzeslowski.jsupla.api.generated.model.ChannelFunctionActionEnum.TURN_OFF;
import static pl.grzeslowski.jsupla.api.generated.model.ChannelFunctionActionEnum.TURN_ON;

public final class ChannelApiImpl implements ChannelApi {
    public static final List<String> DEFAULT_INCLUDE = asList("connected", "state");
    private final ChannelsApi channelsApi;
    private final IoDevicesApi ioDevicesApi;

    public ChannelApiImpl(final ApiClient apiClient) {
        channelsApi = new ChannelsApi(apiClient);
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
            return ioDevicesApi.getIoDeviceChannels(device.getId(), DEFAULT_INCLUDE)
                           .stream()
                           .map(this::mapToChannel)
                           .collect(Collectors.toCollection(TreeSet::new));
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/findChannels/" + device.getId(), e);
        }
    }

    private Channel mapToChannel(pl.grzeslowski.jsupla.api.generated.model.Channel channel) {
        return new ChannelImpl(channel);
    }

    @Override
    public Supplier<Channel> updateState(final Channel channel, final Action action) {
        final ChannelExecuteActionRequest body = buildChannelExecuteActionRequest(action);
        try {
            channelsApi.executeAction(body, channel.getId());
        } catch (ApiException e) {
            throw new pl.grzeslowski.jsupla.api.ApiException("/updateState/" + channel.getId() + "/" + action, e);
        }
        return memoize(() -> findChannel(channel.getId()));
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
            return new ChannelExecuteActionRequest().action(SET_RGBW_PARAMETERS)
                           .color(HsbTypeConverter.INSTANCE.toCloudFormat(brightnessAndColor.getRgb()))
                           .brightness(brightnessAndColor.getBrightness());
        } else if (action instanceof SetColorAction) {
            final SetColorAction colorAction = (SetColorAction) action;
            return new ChannelExecuteActionRequest().action(SET_RGBW_PARAMETERS)
                           .color(HsbTypeConverter.INSTANCE.toCloudFormat(colorAction.getRgb()));
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
}