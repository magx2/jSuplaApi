package pl.grzeslowski.jsupla.api.internal.generated.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public final class CurrentUser {
    @SerializedName("id")
    private Integer id;
    @SerializedName("email")
    private String email;
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("clientsRegistrationEnabled")
    private String clientsRegistrationEnabled;
    @SerializedName("ioDevicesRegistrationEnabled")
    private String ioDevicesRegistrationEnabled;

    public CurrentUser() {
    }

    public CurrentUser(Integer id, String email, String timezone, String clientsRegistrationEnabled, String ioDevicesRegistrationEnabled) {
        this.id = id;
        this.email = email;
        this.timezone = timezone;
        this.clientsRegistrationEnabled = clientsRegistrationEnabled;
        this.ioDevicesRegistrationEnabled = ioDevicesRegistrationEnabled;
    }

    public Integer getId() {
        return id;
    }

    public CurrentUser setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CurrentUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTimezone() {
        return timezone;
    }

    public CurrentUser setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public String getClientsRegistrationEnabled() {
        return clientsRegistrationEnabled;
    }

    public CurrentUser setClientsRegistrationEnabled(String clientsRegistrationEnabled) {
        this.clientsRegistrationEnabled = clientsRegistrationEnabled;
        return this;
    }

    public String getIoDevicesRegistrationEnabled() {
        return ioDevicesRegistrationEnabled;
    }

    public CurrentUser setIoDevicesRegistrationEnabled(String ioDevicesRegistrationEnabled) {
        this.ioDevicesRegistrationEnabled = ioDevicesRegistrationEnabled;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentUser that = (CurrentUser) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(email, that.email) &&
                Objects.equals(timezone, that.timezone) &&
                Objects.equals(clientsRegistrationEnabled, that.clientsRegistrationEnabled) &&
                Objects.equals(ioDevicesRegistrationEnabled, that.ioDevicesRegistrationEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, timezone, clientsRegistrationEnabled, ioDevicesRegistrationEnabled);
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", timezone='" + timezone + '\'' +
                ", clientsRegistrationEnabled='" + clientsRegistrationEnabled + '\'' +
                ", ioDevicesRegistrationEnabled='" + ioDevicesRegistrationEnabled + '\'' +
                '}';
    }
}
