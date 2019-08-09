package pl.grzeslowski.jsupla.api;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.Channel;
import pl.grzeslowski.jsupla.api.channel.action.Action;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

@Getter
@ToString
public final class OutputChannelUpdateException extends RuntimeException {
    @NonNull private final Channel channel;
    @NonNull private final Action action;

    public OutputChannelUpdateException(final Channel channel, final Action action) {
        super(buildMessage(channel, action));
        this.channel = requireNonNull(channel);
        this.action = requireNonNull(action);
    }

    private static String buildMessage(final Channel channel, final Action action) {
        return format("Cannot execute action `%s` on channel with ID `%s` because channel is input (provide data) only!",
                action, channel.getId());
    }
}
