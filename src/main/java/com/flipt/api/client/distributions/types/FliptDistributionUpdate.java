package com.flipt.api.client.distributions.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = FliptDistributionUpdate.Builder.class
)
public final class FliptDistributionUpdate {
  private final String variantId;

  private final double rollout;

  private int _cachedHashCode;

  FliptDistributionUpdate(String variantId, double rollout) {
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
    return other instanceof FliptDistributionUpdate && equalTo((FliptDistributionUpdate) other);
  }

  private boolean equalTo(FliptDistributionUpdate other) {
    return variantId.equals(other.variantId) && rollout == other.rollout;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.variantId, this.rollout);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "FliptDistributionUpdate{" + "variantId: " + variantId + ", rollout: " + rollout + "}";
  }

  public static VariantIdStage builder() {
    return new Builder();
  }

  public interface VariantIdStage {
    RolloutStage variantId(String variantId);

    Builder from(FliptDistributionUpdate other);
  }

  public interface RolloutStage {
    _FinalStage rollout(double rollout);
  }

  public interface _FinalStage {
    FliptDistributionUpdate build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements VariantIdStage, RolloutStage, _FinalStage {
    private String variantId;

    private double rollout;

    private Builder() {
    }

    @Override
    public Builder from(FliptDistributionUpdate other) {
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
    public FliptDistributionUpdate build() {
      return new FliptDistributionUpdate(variantId, rollout);
    }
  }
}
