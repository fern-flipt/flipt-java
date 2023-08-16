package com.flipt.api.resources.rules.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RuleSegmentOperator {
    OR_SEGMENT_OPERATOR("OR_SEGMENT_OPERATOR"),

    AND_SEGMENT_OPERATOR("AND_SEGMENT_OPERATOR");

    private final String value;

    RuleSegmentOperator(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
