package pl.grzeslowski.jsupla.api.channel.state;

import java.math.BigDecimal;
import java.util.SortedSet;

public interface ElectricityMeterState extends State {
    BigDecimal getTotalCost();

    BigDecimal getPricePerUnit();

    String getCurrency();

    PhasesSummary getPhasesSummary();

    SortedSet<Phase> getPhases();

    interface PhasesSummary {
        int getNumberOfPhases();

        /**
         * Frequency in <code>Hz</code>.
         */
        BigDecimal getFrequency();

        /**
         * Active power in <code>W</code>
         */
        BigDecimal getPowerActive();

        /**
         * Reactive power in <code>var</code>
         */
        BigDecimal getPowerReactive();

        /**
         * Apparent power in <code>VA</code>
         */
        BigDecimal getPowerApparent();

        /**
         * Total forward active energy in <code>kWh</code>
         */
        BigDecimal getTotalForwardActiveEnergy();

        /**
         * Total reverse active energy in <code>kWh</code>
         */
        BigDecimal getTotalReverseActiveEnergy();

        /**
         * Total forward reactive energy in <code>kvarh</code>
         */
        BigDecimal getTotalForwardReactiveEnergy();

        /**
         * Total reverse reactive energy in <code>kvarh</code>
         */
        BigDecimal getTotalReverseReactiveEnergy();
    }

    interface Phase extends Comparable<Phase> {
        int getNumber();

        /**
         * Frequency in <code>Hz</code>.
         */
        BigDecimal getFrequency();

        /**
         * Voltage in <code>V</code>
         */
        BigDecimal getVoltage();

        /**
         * Current in <code>A</code>
         */
        BigDecimal getCurrent();

        /**
         * Active power in <code>W</code>
         */
        BigDecimal getPowerActive();

        /**
         * Reactive power in <code>var</code>
         */
        BigDecimal getPowerReactive();

        /**
         * Apparent power in <code>VA</code>
         */
        BigDecimal getPowerApparent();

        /**
         * Power factor. No unit
         */
        BigDecimal getPowerFactor();

        /**
         * Phase angle in <code>°</code>
         */
        BigDecimal getPhaseAngle();

        /**
         * Total forward active energy in <code>kWh</code>
         */
        BigDecimal getTotalForwardActiveEnergy();

        /**
         * Total reverse active energy in <code>kWh</code>
         */
        BigDecimal getTotalReverseActiveEnergy();

        /**
         * Total forward reactive energy in <code>kvarh</code>
         */
        BigDecimal getTotalForwardReactiveEnergy();

        /**
         * Total reverse reactive energy in <code>kvarh</code>
         */
        BigDecimal getTotalReverseReactiveEnergy();

        @Override
        default int compareTo(Phase o) {
            return getNumber() - o.getNumber();
        }
    }
}
