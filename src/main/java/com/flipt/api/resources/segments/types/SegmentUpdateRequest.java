package com.flipt.api.resources.segments.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SegmentUpdateRequest.Builder.class)
public final class SegmentUpdateRequest {
    private final String name;

    private final String description;

    private final SegmentMatchType matchType;

    private SegmentUpdateRequest(String name, String description, SegmentMatchType matchType) {
        this.name = name;
        this.description = description;
        this.matchType = matchType;
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
        return other instanceof SegmentUpdateRequest && equalTo((SegmentUpdateRequest) other);
    }

    private boolean equalTo(SegmentUpdateRequest other) {
        return name.equals(other.name) && description.equals(other.description) && matchType.equals(other.matchType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.description, this.matchType);
    }

    @Override
    public String toString() {
        return "SegmentUpdateRequest{" + "name: " + name + ", description: " + description + ", matchType: " + matchType
                + "}";
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        DescriptionStage name(String name);

        Builder from(SegmentUpdateRequest other);
    }

    public interface DescriptionStage {
        MatchTypeStage description(String description);
    }

    public interface MatchTypeStage {
        _FinalStage matchType(SegmentMatchType matchType);
    }

    public interface _FinalStage {
        SegmentUpdateRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, DescriptionStage, MatchTypeStage, _FinalStage {
        private String name;

        private String description;

        private SegmentMatchType matchType;

        private Builder() {}

        @Override
        public Builder from(SegmentUpdateRequest other) {
            name(other.getName());
            description(other.getDescription());
            matchType(other.getMatchType());
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
        public SegmentUpdateRequest build() {
            return new SegmentUpdateRequest(name, description, matchType);
        }
    }
}
