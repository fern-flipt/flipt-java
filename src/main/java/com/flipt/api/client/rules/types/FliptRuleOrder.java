package com.flipt.api.client.rules.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = FliptRuleOrder.Builder.class
)
public final class FliptRuleOrder {
  private final List<String> ruleIds;

  private int _cachedHashCode;

  FliptRuleOrder(List<String> ruleIds) {
    this.ruleIds = ruleIds;
  }

  @JsonProperty("ruleIds")
  public List<String> getRuleIds() {
    return ruleIds;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FliptRuleOrder && equalTo((FliptRuleOrder) other);
  }

  private boolean equalTo(FliptRuleOrder other) {
    return ruleIds.equals(other.ruleIds);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ruleIds);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "FliptRuleOrder{" + "ruleIds: " + ruleIds + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<String> ruleIds = new ArrayList<>();

    private Builder() {
    }

    public Builder from(FliptRuleOrder other) {
      ruleIds(other.getRuleIds());
      return this;
    }

    @JsonSetter(
        value = "ruleIds",
        nulls = Nulls.SKIP
    )
    public Builder ruleIds(List<String> ruleIds) {
      this.ruleIds.clear();
      this.ruleIds.addAll(ruleIds);
      return this;
    }

    public Builder ruleIds(String ruleIds) {
      this.ruleIds.add(ruleIds);
      return this;
    }

    public Builder addAllRuleIds(List<String> ruleIds) {
      this.ruleIds.addAll(ruleIds);
      return this;
    }

    public FliptRuleOrder build() {
      return new FliptRuleOrder(ruleIds);
    }
  }
}
