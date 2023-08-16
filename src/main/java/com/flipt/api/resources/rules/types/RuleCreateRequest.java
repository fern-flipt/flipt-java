package com.flipt.api.resources.rules.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RuleCreateRequest.Builder.class)
public final class RuleCreateRequest {
    private final String segmentKey;

    private final Optional<List<String>> segmentKeys;

    private final Optional<RuleSegmentOperator> segmentOperator;

    private final int rank;

    private RuleCreateRequest(
            String segmentKey,
            Optional<List<String>> segmentKeys,
            Optional<RuleSegmentOperator> segmentOperator,
            int rank) {
        this.segmentKey = segmentKey;
        this.segmentKeys = segmentKeys;
        this.segmentOperator = segmentOperator;
        this.rank = rank;
    }

    @JsonProperty("segmentKey")
    public String getSegmentKey() {
        return segmentKey;
    }

    @JsonProperty("segmentKeys")
    public Optional<List<String>> getSegmentKeys() {
        return segmentKeys;
    }

    @JsonProperty("segmentOperator")
    public Optional<RuleSegmentOperator> getSegmentOperator() {
        return segmentOperator;
    }

    @JsonProperty("rank")
    public int getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RuleCreateRequest && equalTo((RuleCreateRequest) other);
    }

    private boolean equalTo(RuleCreateRequest other) {
        return segmentKey.equals(other.segmentKey)
                && segmentKeys.equals(other.segmentKeys)
                && segmentOperator.equals(other.segmentOperator)
                && rank == other.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.segmentKey, this.segmentKeys, this.segmentOperator, this.rank);
    }

    @Override
    public String toString() {
        return "RuleCreateRequest{" + "segmentKey: " + segmentKey + ", segmentKeys: " + segmentKeys
                + ", segmentOperator: " + segmentOperator + ", rank: " + rank + "}";
    }

    public static SegmentKeyStage builder() {
        return new Builder();
    }

    public interface SegmentKeyStage {
        RankStage segmentKey(String segmentKey);

        Builder from(RuleCreateRequest other);
    }

    public interface RankStage {
        _FinalStage rank(int rank);
    }

    public interface _FinalStage {
        RuleCreateRequest build();

        _FinalStage segmentKeys(Optional<List<String>> segmentKeys);

        _FinalStage segmentKeys(List<String> segmentKeys);

        _FinalStage segmentOperator(Optional<RuleSegmentOperator> segmentOperator);

        _FinalStage segmentOperator(RuleSegmentOperator segmentOperator);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SegmentKeyStage, RankStage, _FinalStage {
        private String segmentKey;

        private int rank;

        private Optional<RuleSegmentOperator> segmentOperator = Optional.empty();

        private Optional<List<String>> segmentKeys = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(RuleCreateRequest other) {
            segmentKey(other.getSegmentKey());
            segmentKeys(other.getSegmentKeys());
            segmentOperator(other.getSegmentOperator());
            rank(other.getRank());
            return this;
        }

        @Override
        @JsonSetter("segmentKey")
        public RankStage segmentKey(String segmentKey) {
            this.segmentKey = segmentKey;
            return this;
        }

        @Override
        @JsonSetter("rank")
        public _FinalStage rank(int rank) {
            this.rank = rank;
            return this;
        }

        @Override
        public _FinalStage segmentOperator(RuleSegmentOperator segmentOperator) {
            this.segmentOperator = Optional.of(segmentOperator);
            return this;
        }

        @Override
        @JsonSetter(value = "segmentOperator", nulls = Nulls.SKIP)
        public _FinalStage segmentOperator(Optional<RuleSegmentOperator> segmentOperator) {
            this.segmentOperator = segmentOperator;
            return this;
        }

        @Override
        public _FinalStage segmentKeys(List<String> segmentKeys) {
            this.segmentKeys = Optional.of(segmentKeys);
            return this;
        }

        @Override
        @JsonSetter(value = "segmentKeys", nulls = Nulls.SKIP)
        public _FinalStage segmentKeys(Optional<List<String>> segmentKeys) {
            this.segmentKeys = segmentKeys;
            return this;
        }

        @Override
        public RuleCreateRequest build() {
            return new RuleCreateRequest(segmentKey, segmentKeys, segmentOperator, rank);
        }
    }
}
