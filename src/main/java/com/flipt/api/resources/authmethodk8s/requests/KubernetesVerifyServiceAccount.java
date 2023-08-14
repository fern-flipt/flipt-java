package com.flipt.api.resources.authmethodk8s.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = KubernetesVerifyServiceAccount.Builder.class)
public final class KubernetesVerifyServiceAccount {
    private final String serviceAccountToken;

    private KubernetesVerifyServiceAccount(String serviceAccountToken) {
        this.serviceAccountToken = serviceAccountToken;
    }

    @JsonProperty("serviceAccountToken")
    public String getServiceAccountToken() {
        return serviceAccountToken;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof KubernetesVerifyServiceAccount && equalTo((KubernetesVerifyServiceAccount) other);
    }

    private boolean equalTo(KubernetesVerifyServiceAccount other) {
        return serviceAccountToken.equals(other.serviceAccountToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.serviceAccountToken);
    }

    @Override
    public String toString() {
        return "KubernetesVerifyServiceAccount{" + "serviceAccountToken: " + serviceAccountToken + "}";
    }

    public static ServiceAccountTokenStage builder() {
        return new Builder();
    }

    public interface ServiceAccountTokenStage {
        _FinalStage serviceAccountToken(String serviceAccountToken);

        Builder from(KubernetesVerifyServiceAccount other);
    }

    public interface _FinalStage {
        KubernetesVerifyServiceAccount build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ServiceAccountTokenStage, _FinalStage {
        private String serviceAccountToken;

        private Builder() {}

        @Override
        public Builder from(KubernetesVerifyServiceAccount other) {
            serviceAccountToken(other.getServiceAccountToken());
            return this;
        }

        @Override
        @JsonSetter("serviceAccountToken")
        public _FinalStage serviceAccountToken(String serviceAccountToken) {
            this.serviceAccountToken = serviceAccountToken;
            return this;
        }

        @Override
        public KubernetesVerifyServiceAccount build() {
            return new KubernetesVerifyServiceAccount(serviceAccountToken);
        }
    }
}
