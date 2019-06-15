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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ChannelUpdateConfirmationResponse
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-03-28T22:45:22.163Z[GMT]")
public class ChannelUpdateConfirmationResponse {

    @SerializedName("schedules")
    private List<Schedule> schedules = null;

    @SerializedName("groups")
    private List<ChannelGroup> groups = null;

    public ChannelUpdateConfirmationResponse schedules(List<Schedule> schedules) {
        this.schedules = schedules;
        return this;
    }

    public ChannelUpdateConfirmationResponse addSchedulesItem(Schedule schedulesItem) {
        if (this.schedules == null) {
            this.schedules = new ArrayList<Schedule>();
        }
        this.schedules.add(schedulesItem);
        return this;
    }

    /**
     * Schedules that will be deleted after this request.
     *
     * @return schedules
     **/
    @Schema(description = "Schedules that will be deleted after this request.")
    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public ChannelUpdateConfirmationResponse groups(List<ChannelGroup> groups) {
        this.groups = groups;
        return this;
    }

    public ChannelUpdateConfirmationResponse addGroupsItem(ChannelGroup groupsItem) {
        if (this.groups == null) {
            this.groups = new ArrayList<ChannelGroup>();
        }
        this.groups.add(groupsItem);
        return this;
    }

    /**
     * Channel groups that this channel will be removed from after this request.
     *
     * @return groups
     **/
    @Schema(description = "Channel groups that this channel will be removed from after this request.")
    public List<ChannelGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<ChannelGroup> groups) {
        this.groups = groups;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChannelUpdateConfirmationResponse channelUpdateConfirmationResponse = (ChannelUpdateConfirmationResponse) o;
        return Objects.equals(this.schedules, channelUpdateConfirmationResponse.schedules) &&
                       Objects.equals(this.groups, channelUpdateConfirmationResponse.groups);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(schedules, groups);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChannelUpdateConfirmationResponse {\n");

        sb.append("    schedules: ").append(toIndentedString(schedules)).append("\n");
        sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
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