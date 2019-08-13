package pl.grzeslowski.jsupla.api.channel.state;

public interface GateState extends State {
    Position getPosition();

    enum Position {
        OPENED, CLOSED, PARTIALLY_OPENED
    }
}
