package com.flipt.api.resources.rollouts.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RolloutType {
    UNKNOWN_ROLLOUT_TYPE("UNKNOWN_ROLLOUT_TYPE"),

    SEGMENT_ROLLOUT_TYPE("SEGMENT_ROLLOUT_TYPE"),

    THRESHOLD_ROLLOUT_TYPE("THRESHOLD_ROLLOUT_TYPE");

    private final String value;

    RolloutType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
