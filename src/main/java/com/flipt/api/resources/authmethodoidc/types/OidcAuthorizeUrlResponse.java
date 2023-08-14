package com.flipt.api.resources.authmethodoidc.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = OidcAuthorizeUrlResponse.Builder.class)
public final class OidcAuthorizeUrlResponse {
    private final String authorizeUrl;

    private OidcAuthorizeUrlResponse(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }

    @JsonProperty("authorizeUrl")
    public String getAuthorizeUrl() {
        return authorizeUrl;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof OidcAuthorizeUrlResponse && equalTo((OidcAuthorizeUrlResponse) other);
    }

    private boolean equalTo(OidcAuthorizeUrlResponse other) {
        return authorizeUrl.equals(other.authorizeUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.authorizeUrl);
    }

    @Override
    public String toString() {
        return "OidcAuthorizeUrlResponse{" + "authorizeUrl: " + authorizeUrl + "}";
    }

    public static AuthorizeUrlStage builder() {
        return new Builder();
    }

    public interface AuthorizeUrlStage {
        _FinalStage authorizeUrl(String authorizeUrl);

        Builder from(OidcAuthorizeUrlResponse other);
    }

    public interface _FinalStage {
        OidcAuthorizeUrlResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements AuthorizeUrlStage, _FinalStage {
        private String authorizeUrl;

        private Builder() {}

        @Override
        public Builder from(OidcAuthorizeUrlResponse other) {
            authorizeUrl(other.getAuthorizeUrl());
            return this;
        }

        @Override
        @JsonSetter("authorizeUrl")
        public _FinalStage authorizeUrl(String authorizeUrl) {
            this.authorizeUrl = authorizeUrl;
            return this;
        }

        @Override
        public OidcAuthorizeUrlResponse build() {
            return new OidcAuthorizeUrlResponse(authorizeUrl);
        }
    }
}
