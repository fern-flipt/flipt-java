package com.flipt.api.resources.flags.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FlagType {
    VARIANT_FLAG_TYPE("VARIANT_FLAG_TYPE"),

    BOOLEAN_FLAG_TYPE("BOOLEAN_FLAG_TYPE");

    private final String value;

    FlagType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
