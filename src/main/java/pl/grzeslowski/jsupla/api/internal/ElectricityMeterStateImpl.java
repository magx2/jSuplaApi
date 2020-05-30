package pl.grzeslowski.jsupla.api.internal;

import io.swagger.client.model.Channel;
import io.swagger.client.model.ChannelState;
import lombok.Builder;
import lombok.Value;
import pl.grzeslowski.jsupla.api.channel.state.ElectricityMeterState;

import java.math.BigDecimal;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Value
class ElectricityMeterStateImpl implements ElectricityMeterState {
    BigDecimal totalCost;
    BigDecimal pricePerUnit;
    String currency;
    SortedSet<Phase> phases;

    public ElectricityMeterStateImpl(final Channel channel) {
        final ChannelState state = channel.getState();
        totalCost = state.getTotalCost();
        pricePerUnit = state.getPricePerUnit();
        currency = state.getCurrency();
        phases = state.getPhases()
                         .stream()
                         .map(p -> PhaseImpl.builder()
                                           .number(p.getNumber().intValue())
                                           .frequency(p.getFrequency())
                                           .voltage(p.getVoltage())
                                           .current(p.getCurrent())
                                           .powerActive(p.getPowerActive())
                                           .powerReactive(p.getPowerReactive())
                                           .powerApparent(p.getPowerApparent())
                                           .powerFactor(p.getPowerFactor())
                                           .phaseAngle(p.getPhaseAngle())
                                           .totalForwardActiveEnergy(p.getTotalForwardActiveEnergy())
                                           .totalReverseActiveEnergy(p.getTotalReverseActiveEnergy())
                                           .totalForwardReactiveEnergy(p.getTotalForwardReactiveEnergy())
                                           .totalReverseReactiveEnergy(p.getTotalReverseReactiveEnergy())
                                           .build())
                         .collect(Collectors.toCollection(TreeSet::new));
    }

    @Builder
    @Value
    static class PhaseImpl implements Phase {
        int number;
        BigDecimal frequency;
        BigDecimal voltage;
        BigDecimal current;
        BigDecimal powerActive;
        BigDecimal powerReactive;
        BigDecimal powerApparent;
        BigDecimal powerFactor;
        BigDecimal phaseAngle;
        BigDecimal totalForwardActiveEnergy;
        BigDecimal totalReverseActiveEnergy;
        BigDecimal totalForwardReactiveEnergy;
        BigDecimal totalReverseReactiveEnergy;
    }
}
