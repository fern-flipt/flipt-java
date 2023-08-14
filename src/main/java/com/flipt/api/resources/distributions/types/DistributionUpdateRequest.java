package com.flipt.api.resources.distributions.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DistributionUpdateRequest.Builder.class)
public final class DistributionUpdateRequest {
    private final String variantId;

    private final double rollout;

    private DistributionUpdateRequest(String variantId, double rollout) {
        this.variantId = variantId;
        this.rollout = rollout;
    }

    @JsonProperty("variantId")
    public String getVariantId() {
        return variantId;
    }

    @JsonProperty("rollout")
    public double getRollout() {
        return rollout;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DistributionUpdateRequest && equalTo((DistributionUpdateRequest) other);
    }

    private boolean equalTo(DistributionUpdateRequest other) {
        return variantId.equals(other.variantId) && rollout == other.rollout;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.variantId, this.rollout);
    }

    @Override
    public String toString() {
        return "DistributionUpdateRequest{" + "variantId: " + variantId + ", rollout: " + rollout + "}";
    }

    public static VariantIdStage builder() {
        return new Builder();
    }

    public interface VariantIdStage {
        RolloutStage variantId(String variantId);

        Builder from(DistributionUpdateRequest other);
    }

    public interface RolloutStage {
        _FinalStage rollout(double rollout);
    }

    public interface _FinalStage {
        DistributionUpdateRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements VariantIdStage, RolloutStage, _FinalStage {
        private String variantId;

        private double rollout;

        private Builder() {}

        @Override
        public Builder from(DistributionUpdateRequest other) {
            variantId(other.getVariantId());
            rollout(other.getRollout());
            return this;
        }

        @Override
        @JsonSetter("variantId")
        public RolloutStage variantId(String variantId) {
            this.variantId = variantId;
            return this;
        }

        @Override
        @JsonSetter("rollout")
        public _FinalStage rollout(double rollout) {
            this.rollout = rollout;
            return this;
        }

        @Override
        public DistributionUpdateRequest build() {
            return new DistributionUpdateRequest(variantId, rollout);
        }
    }
}
