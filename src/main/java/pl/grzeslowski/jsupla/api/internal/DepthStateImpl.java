package pl.grzeslowski.jsupla.api.internal;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import pl.grzeslowski.jsupla.api.channel.state.DepthState;

import java.math.BigDecimal;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
final class DepthStateImpl implements DepthState {
    @NonNull private final BigDecimal depth;
}
