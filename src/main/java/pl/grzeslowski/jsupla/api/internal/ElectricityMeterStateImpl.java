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

import static java.math.RoundingMode.CEILING;

@Value
class ElectricityMeterStateImpl implements ElectricityMeterState {
    BigDecimal totalCost;
    BigDecimal pricePerUnit;
    String currency;
    PhasesSummary phasesSummary;
    SortedSet<Phase> phases;

    private static BigDecimal computeFrequency(final SortedSet<Phase> phases) {
        final BigDecimal frequencySum = phases.stream()
                                                .map(Phase::getFrequency)
                                                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return frequencySum.divide(new BigDecimal(phases.size()), 2, CEILING);
    }

    private static BigDecimal computePowerActive(final SortedSet<Phase> phases) {
        return phases.stream()
                       .map(Phase::getPowerActive)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal computePowerReactive(final SortedSet<Phase> phases) {
        return phases.stream()
                       .map(Phase::getPowerReactive)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal computePowerApparent(final SortedSet<Phase> phases) {
        return phases.stream()
                       .map(Phase::getPowerApparent)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal computeTotalForwardActiveEnergy(final SortedSet<Phase> phases) {
        return phases.stream()
                       .map(Phase::getTotalForwardActiveEnergy)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal computeTotalReverseActiveEnergy(final SortedSet<Phase> phases) {
        return phases.stream()
                       .map(Phase::getTotalReverseActiveEnergy)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal computeTotalForwardReactiveEnergy(final SortedSet<Phase> phases) {
        return phases.stream()
                       .map(Phase::getTotalForwardReactiveEnergy)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static BigDecimal computeTotalReverseReactiveEnergy(final SortedSet<Phase> phases) {
        return phases.stream()
                       .map(Phase::getTotalReverseReactiveEnergy)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

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
        phasesSummary = PhasesSummaryImpl.builder()
                                .numberOfPhases(phases.size())
                                .frequency(computeFrequency(phases))
                                .powerActive(computePowerActive(phases))
                                .powerReactive(computePowerReactive(phases))
                                .powerApparent(computePowerApparent(phases))
                                .totalForwardActiveEnergy(computeTotalForwardActiveEnergy(phases))
                                .totalReverseActiveEnergy(computeTotalReverseActiveEnergy(phases))
                                .totalForwardReactiveEnergy(computeTotalForwardReactiveEnergy(phases))
                                .totalReverseReactiveEnergy(computeTotalReverseReactiveEnergy(phases))
                                .build();
    }

    @Builder
    @Value
    private static class PhasesSummaryImpl implements PhasesSummary {
        int numberOfPhases;
        BigDecimal frequency;
        BigDecimal powerActive;
        BigDecimal powerReactive;
        BigDecimal powerApparent;
        BigDecimal totalForwardActiveEnergy;
        BigDecimal totalReverseActiveEnergy;
        BigDecimal totalForwardReactiveEnergy;
        BigDecimal totalReverseReactiveEnergy;
    }

    @Builder
    @Value
    private static class PhaseImpl implements Phase {
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
