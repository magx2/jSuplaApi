/*
 * SUPLA Cloud API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 2.3.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package pl.grzeslowski.jsupla.api.internal.generated.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;

import java.util.Objects;

/**
 * UserData
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-03-28T22:45:22.163Z[GMT]")
public class UserData {

    @SerializedName("id")
    private Integer id = null;

    @SerializedName("shortUniqueId")
    private String shortUniqueId = null;

    @SerializedName("email")
    private String email = null;

    @SerializedName("timezone")
    private String timezone = null;

    @SerializedName("clientsRegistrationEnabled")
    private OffsetDateTime clientsRegistrationEnabled = null;

    @SerializedName("ioDevicesRegistrationEnabled")
    private OffsetDateTime ioDevicesRegistrationEnabled = null;

    public UserData id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @Schema(description = "")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserData shortUniqueId(String shortUniqueId) {
        this.shortUniqueId = shortUniqueId;
        return this;
    }

    /**
     * Get shortUniqueId
     *
     * @return shortUniqueId
     **/
    @Schema(description = "")
    public String getShortUniqueId() {
        return shortUniqueId;
    }

    public void setShortUniqueId(String shortUniqueId) {
        this.shortUniqueId = shortUniqueId;
    }

    public UserData email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     **/
    @Schema(description = "")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserData timezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    /**
     * Get timezone
     *
     * @return timezone
     **/
    @Schema(example = "Europe/Warsaw", description = "")
    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public UserData clientsRegistrationEnabled(OffsetDateTime clientsRegistrationEnabled) {
        this.clientsRegistrationEnabled = clientsRegistrationEnabled;
        return this;
    }

    /**
     * Get clientsRegistrationEnabled
     *
     * @return clientsRegistrationEnabled
     **/
    @Schema(description = "")
    public OffsetDateTime getClientsRegistrationEnabled() {
        return clientsRegistrationEnabled;
    }

    public void setClientsRegistrationEnabled(OffsetDateTime clientsRegistrationEnabled) {
        this.clientsRegistrationEnabled = clientsRegistrationEnabled;
    }

    public UserData ioDevicesRegistrationEnabled(OffsetDateTime ioDevicesRegistrationEnabled) {
        this.ioDevicesRegistrationEnabled = ioDevicesRegistrationEnabled;
        return this;
    }

    /**
     * Get ioDevicesRegistrationEnabled
     *
     * @return ioDevicesRegistrationEnabled
     **/
    @Schema(description = "")
    public OffsetDateTime getIoDevicesRegistrationEnabled() {
        return ioDevicesRegistrationEnabled;
    }

    public void setIoDevicesRegistrationEnabled(OffsetDateTime ioDevicesRegistrationEnabled) {
        this.ioDevicesRegistrationEnabled = ioDevicesRegistrationEnabled;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserData userData = (UserData) o;
        return Objects.equals(this.id, userData.id) &&
                       Objects.equals(this.shortUniqueId, userData.shortUniqueId) &&
                       Objects.equals(this.email, userData.email) &&
                       Objects.equals(this.timezone, userData.timezone) &&
                       Objects.equals(this.clientsRegistrationEnabled, userData.clientsRegistrationEnabled) &&
                       Objects.equals(this.ioDevicesRegistrationEnabled, userData.ioDevicesRegistrationEnabled);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, shortUniqueId, email, timezone, clientsRegistrationEnabled, ioDevicesRegistrationEnabled);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserData {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    shortUniqueId: ").append(toIndentedString(shortUniqueId)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    timezone: ").append(toIndentedString(timezone)).append("\n");
        sb.append("    clientsRegistrationEnabled: ").append(toIndentedString(clientsRegistrationEnabled)).append("\n");
        sb.append("    ioDevicesRegistrationEnabled: ").append(toIndentedString(ioDevicesRegistrationEnabled)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}