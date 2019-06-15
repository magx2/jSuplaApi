package pl.grzeslowski.jsupla.api.channel.state;

public interface State {
    Class<? extends State> getType();

    <T extends State> T castTo(Class<? extends T> clazz);
}
