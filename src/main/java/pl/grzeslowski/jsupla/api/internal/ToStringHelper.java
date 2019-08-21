package pl.grzeslowski.jsupla.api.internal;

final class ToStringHelper {
    static String niceToString(Object o) {
        return o.toString()
                       .replaceAll("\n", ", ")
                       .replaceAll("\\s+", " ");
    }
}
