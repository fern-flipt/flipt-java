/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.flipt.api.resources.evaluation.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BatchEvaluationRequest.Builder.class)
public final class BatchEvaluationRequest {
    private final Optional<String> requestId;

    private final List<EvaluationRequest> requests;

    private final Optional<String> reference;

    private BatchEvaluationRequest(
            Optional<String> requestId, List<EvaluationRequest> requests, Optional<String> reference) {
        this.requestId = requestId;
        this.requests = requests;
        this.reference = reference;
    }

    @JsonProperty("requestId")
    public Optional<String> getRequestId() {
        return requestId;
    }

    @JsonProperty("requests")
    public List<EvaluationRequest> getRequests() {
        return requests;
    }

    @JsonProperty("reference")
    public Optional<String> getReference() {
        return reference;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BatchEvaluationRequest && equalTo((BatchEvaluationRequest) other);
    }

    private boolean equalTo(BatchEvaluationRequest other) {
        return requestId.equals(other.requestId)
                && requests.equals(other.requests)
                && reference.equals(other.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.requestId, this.requests, this.reference);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> requestId = Optional.empty();

        private List<EvaluationRequest> requests = new ArrayList<>();

        private Optional<String> reference = Optional.empty();

        private Builder() {}

        public Builder from(BatchEvaluationRequest other) {
            requestId(other.getRequestId());
            requests(other.getRequests());
            reference(other.getReference());
            return this;
        }

        @JsonSetter(value = "requestId", nulls = Nulls.SKIP)
        public Builder requestId(Optional<String> requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder requestId(String requestId) {
            this.requestId = Optional.of(requestId);
            return this;
        }

        @JsonSetter(value = "requests", nulls = Nulls.SKIP)
        public Builder requests(List<EvaluationRequest> requests) {
            this.requests.clear();
            this.requests.addAll(requests);
            return this;
        }

        public Builder addRequests(EvaluationRequest requests) {
            this.requests.add(requests);
            return this;
        }

        public Builder addAllRequests(List<EvaluationRequest> requests) {
            this.requests.addAll(requests);
            return this;
        }

        @JsonSetter(value = "reference", nulls = Nulls.SKIP)
        public Builder reference(Optional<String> reference) {
            this.reference = reference;
            return this;
        }

        public Builder reference(String reference) {
            this.reference = Optional.of(reference);
            return this;
        }

        public BatchEvaluationRequest build() {
            return new BatchEvaluationRequest(requestId, requests, reference);
        }
    }
}
