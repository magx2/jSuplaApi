package pl.grzeslowski.jsupla.api.channel.state;

public interface OnOffState extends State {
    OnOff getOnfOff();

    enum OnOff {
        ON, OFF
    }
}
