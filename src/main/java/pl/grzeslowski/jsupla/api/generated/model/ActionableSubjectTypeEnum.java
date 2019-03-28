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

package pl.grzeslowski.jsupla.api.generated.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gets or Sets ActionableSubjectTypeEnum
 */
@JsonAdapter(ActionableSubjectTypeEnum.Adapter.class)
public enum ActionableSubjectTypeEnum {
    CHANNEL("channel"),
    CHANNELGROUP("channelGroup");

    private String value;

    ActionableSubjectTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static ActionableSubjectTypeEnum fromValue(String text) {
        for (ActionableSubjectTypeEnum b : ActionableSubjectTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    public static class Adapter extends TypeAdapter<ActionableSubjectTypeEnum> {
        @Override
        public void write(final JsonWriter jsonWriter, final ActionableSubjectTypeEnum enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public ActionableSubjectTypeEnum read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return ActionableSubjectTypeEnum.fromValue(String.valueOf(value));
        }
    }
}
