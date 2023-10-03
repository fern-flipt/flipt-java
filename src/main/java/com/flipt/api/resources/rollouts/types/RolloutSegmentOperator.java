/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.flipt.api.resources.rollouts.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RolloutSegmentOperator {
    OR_SEGMENT_OPERATOR("OR_SEGMENT_OPERATOR"),

    AND_SEGMENT_OPERATOR("AND_SEGMENT_OPERATOR");

    private final String value;

    RolloutSegmentOperator(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
