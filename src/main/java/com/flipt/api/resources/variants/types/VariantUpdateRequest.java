package com.flipt.api.resources.variants.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = VariantUpdateRequest.Builder.class)
public final class VariantUpdateRequest {
    private final String key;

    private final Optional<String> name;

    private final Optional<String> description;

    private final Optional<String> attachment;

    private VariantUpdateRequest(
            String key, Optional<String> name, Optional<String> description, Optional<String> attachment) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.attachment = attachment;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("name")
    public Optional<String> getName() {
        return name;
    }

    @JsonProperty("description")
    public Optional<String> getDescription() {
        return description;
    }

    @JsonProperty("attachment")
    public Optional<String> getAttachment() {
        return attachment;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof VariantUpdateRequest && equalTo((VariantUpdateRequest) other);
    }

    private boolean equalTo(VariantUpdateRequest other) {
        return key.equals(other.key)
                && name.equals(other.name)
                && description.equals(other.description)
                && attachment.equals(other.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key, this.name, this.description, this.attachment);
    }

    @Override
    public String toString() {
        return "VariantUpdateRequest{" + "key: " + key + ", name: " + name + ", description: " + description
                + ", attachment: " + attachment + "}";
    }

    public static KeyStage builder() {
        return new Builder();
    }

    public interface KeyStage {
        _FinalStage key(String key);

        Builder from(VariantUpdateRequest other);
    }

    public interface _FinalStage {
        VariantUpdateRequest build();

        _FinalStage name(Optional<String> name);

        _FinalStage name(String name);

        _FinalStage description(Optional<String> description);

        _FinalStage description(String description);

        _FinalStage attachment(Optional<String> attachment);

        _FinalStage attachment(String attachment);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements KeyStage, _FinalStage {
        private String key;

        private Optional<String> attachment = Optional.empty();

        private Optional<String> description = Optional.empty();

        private Optional<String> name = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(VariantUpdateRequest other) {
            key(other.getKey());
            name(other.getName());
            description(other.getDescription());
            attachment(other.getAttachment());
            return this;
        }

        @Override
        @JsonSetter("key")
        public _FinalStage key(String key) {
            this.key = key;
            return this;
        }

        @Override
        public _FinalStage attachment(String attachment) {
            this.attachment = Optional.of(attachment);
            return this;
        }

        @Override
        @JsonSetter(value = "attachment", nulls = Nulls.SKIP)
        public _FinalStage attachment(Optional<String> attachment) {
            this.attachment = attachment;
            return this;
        }

        @Override
        public _FinalStage description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        @Override
        @JsonSetter(value = "description", nulls = Nulls.SKIP)
        public _FinalStage description(Optional<String> description) {
            this.description = description;
            return this;
        }

        @Override
        public _FinalStage name(String name) {
            this.name = Optional.of(name);
            return this;
        }

        @Override
        @JsonSetter(value = "name", nulls = Nulls.SKIP)
        public _FinalStage name(Optional<String> name) {
            this.name = name;
            return this;
        }

        @Override
        public VariantUpdateRequest build() {
            return new VariantUpdateRequest(key, name, description, attachment);
        }
    }
}
