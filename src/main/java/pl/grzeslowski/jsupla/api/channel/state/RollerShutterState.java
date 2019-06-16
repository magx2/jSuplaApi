package pl.grzeslowski.jsupla.api.channel.state;

public interface RollerShutterState extends OnOffState {
    boolean isCalibrating();

    Percentage getShut();
}
