package com.flipt.api.resources.segments.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SegmentCreateRequest.Builder.class)
public final class SegmentCreateRequest {
    private final String key;

    private final String name;

    private final String description;

    private final SegmentMatchType matchType;

    private SegmentCreateRequest(String key, String name, String description, SegmentMatchType matchType) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.matchType = matchType;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("matchType")
    public SegmentMatchType getMatchType() {
        return matchType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SegmentCreateRequest && equalTo((SegmentCreateRequest) other);
    }

    private boolean equalTo(SegmentCreateRequest other) {
        return key.equals(other.key)
                && name.equals(other.name)
                && description.equals(other.description)
                && matchType.equals(other.matchType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key, this.name, this.description, this.matchType);
    }

    @Override
    public String toString() {
        return "SegmentCreateRequest{" + "key: " + key + ", name: " + name + ", description: " + description
                + ", matchType: " + matchType + "}";
    }

    public static KeyStage builder() {
        return new Builder();
    }

    public interface KeyStage {
        NameStage key(String key);

        Builder from(SegmentCreateRequest other);
    }

    public interface NameStage {
        DescriptionStage name(String name);
    }

    public interface DescriptionStage {
        MatchTypeStage description(String description);
    }

    public interface MatchTypeStage {
        _FinalStage matchType(SegmentMatchType matchType);
    }

    public interface _FinalStage {
        SegmentCreateRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements KeyStage, NameStage, DescriptionStage, MatchTypeStage, _FinalStage {
        private String key;

        private String name;

        private String description;

        private SegmentMatchType matchType;

        private Builder() {}

        @Override
        public Builder from(SegmentCreateRequest other) {
            key(other.getKey());
            name(other.getName());
            description(other.getDescription());
            matchType(other.getMatchType());
            return this;
        }

        @Override
        @JsonSetter("key")
        public NameStage key(String key) {
            this.key = key;
            return this;
        }

        @Override
        @JsonSetter("name")
        public DescriptionStage name(String name) {
            this.name = name;
            return this;
        }

        @Override
        @JsonSetter("description")
        public MatchTypeStage description(String description) {
            this.description = description;
            return this;
        }

        @Override
        @JsonSetter("matchType")
        public _FinalStage matchType(SegmentMatchType matchType) {
            this.matchType = matchType;
            return this;
        }

        @Override
        public SegmentCreateRequest build() {
            return new SegmentCreateRequest(key, name, description, matchType);
        }
    }
}
