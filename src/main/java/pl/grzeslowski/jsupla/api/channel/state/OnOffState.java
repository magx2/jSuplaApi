package pl.grzeslowski.jsupla.api.channel.state;

public interface OnOffState extends State {
    OnOff getOnOffState();

    enum OnOff {
        ON, OFF;

        public OnOff invert() {
            if (this == ON) {
                return OFF;
            } else {
                return ON;
            }
        }
    }
}
