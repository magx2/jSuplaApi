package pl.grzeslowski.jsupla.api.channel.state;

import java.math.BigDecimal;
import java.util.SortedSet;

public interface ElectricityMeterState extends State {
    BigDecimal getTotalCost();

    BigDecimal getPricePerUnit();

    String getCurrency();

    SortedSet<Phase> getPhases();

    interface Phase extends Comparable<Phase> {
        int getNumber();

        BigDecimal getFrequency();

        BigDecimal getVoltage();

        BigDecimal getCurrent();

        BigDecimal getPowerActive();

        BigDecimal getPowerReactive();

        BigDecimal getPowerApparent();

        BigDecimal getPowerFactor();

        BigDecimal getPhaseAngle();

        BigDecimal getTotalForwardActiveEnergy();

        BigDecimal getTotalReverseActiveEnergy();

        BigDecimal getTotalForwardReactiveEnergy();

        BigDecimal getTotalReverseReactiveEnergy();

        @Override
        default int compareTo(Phase o) {
            return getNumber() - o.getNumber();
        }
    }
}
