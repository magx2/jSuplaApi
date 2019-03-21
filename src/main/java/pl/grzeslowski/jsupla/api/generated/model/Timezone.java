package pl.grzeslowski.jsupla.api.generated.model;

import java.util.Objects;

public class Timezone {
    private String name;
    private Integer offset;

    public Timezone() {
    }

    public Timezone(String name, Integer offset) {
        this.name = name;
        this.offset = offset;
    }

    public String getName() {
        return name;
    }

    public Timezone setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public Timezone setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timezone timezone = (Timezone) o;
        return Objects.equals(name, timezone.name) &&
                Objects.equals(offset, timezone.offset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, offset);
    }

    @Override
    public String toString() {
        return "Timezone{" +
                "name='" + name + '\'' +
                ", offset=" + offset +
                '}';
    }
}
