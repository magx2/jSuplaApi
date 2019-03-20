package pl.grzeslowski.jsupla.api.generated.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class ServerInfo {
    @SerializedName("address")
    private String address;
    @SerializedName("time")
    private String time;
    @SerializedName("timezone")
    private Timezone timezone;
    @SerializedName("authenticated")
    private Boolean authenticated;
    @SerializedName("username")
    private String username;
    @SerializedName("cloudVersion")
    private String cloudVersion;
    @SerializedName("apiVersion")
    private String apiVersion;
    @SerializedName("supportedApiVersions")
    private List<String> supportedApiVersions;

    public ServerInfo() {
    }

    public ServerInfo(String address, String time, Timezone timezone, Boolean authenticated, String username, String cloudVersion, String apiVersion, List<String> supportedApiVersions) {
        this.address = address;
        this.time = time;
        this.timezone = timezone;
        this.authenticated = authenticated;
        this.username = username;
        this.cloudVersion = cloudVersion;
        this.apiVersion = apiVersion;
        this.supportedApiVersions = supportedApiVersions;
    }

    public String getAddress() {
        return address;
    }

    public ServerInfo setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getTime() {
        return time;
    }

    public ServerInfo setTime(String time) {
        this.time = time;
        return this;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public ServerInfo setTimezone(Timezone timezone) {
        this.timezone = timezone;
        return this;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public ServerInfo setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ServerInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getCloudVersion() {
        return cloudVersion;
    }

    public ServerInfo setCloudVersion(String cloudVersion) {
        this.cloudVersion = cloudVersion;
        return this;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public ServerInfo setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public List<String> getSupportedApiVersions() {
        return supportedApiVersions;
    }

    public ServerInfo setSupportedApiVersions(List<String> supportedApiVersions) {
        this.supportedApiVersions = supportedApiVersions;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerInfo that = (ServerInfo) o;
        return Objects.equals(address, that.address) &&
                Objects.equals(time, that.time) &&
                Objects.equals(timezone, that.timezone) &&
                Objects.equals(authenticated, that.authenticated) &&
                Objects.equals(username, that.username) &&
                Objects.equals(cloudVersion, that.cloudVersion) &&
                Objects.equals(apiVersion, that.apiVersion) &&
                Objects.equals(supportedApiVersions, that.supportedApiVersions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "address='" + address + '\'' +
                ", time='" + time + '\'' +
                ", timezone=" + timezone +
                ", authenticated=" + authenticated +
                ", username='" + username + '\'' +
                ", cloudVersion='" + cloudVersion + '\'' +
                ", apiVersion='" + apiVersion + '\'' +
                ", supportedApiVersions=" + supportedApiVersions +
                '}';
    }
}
