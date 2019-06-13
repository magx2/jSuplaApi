package pl.grzeslowski.jsupla.api.channel.state;

import java.math.BigDecimal;

public interface DepthState extends State {
    BigDecimal getDepth();
}
