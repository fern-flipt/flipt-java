package com.flipt.api.client.flags.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.flipt.api.client.variants.types.FliptVariant;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = FliptFlag.Builder.class
)
public final class FliptFlag {
  private final String key;

  private final String name;

  private final String description;

  private final boolean enabled;

  private final String createdAt;

  private final String updatedAt;

  private final List<FliptVariant> variants;

  private int _cachedHashCode;

  FliptFlag(String key, String name, String description, boolean enabled, String createdAt,
      String updatedAt, List<FliptVariant> variants) {
    this.key = key;
    this.name = name;
    this.description = description;
    this.enabled = enabled;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.variants = variants;
  }

  @JsonProperty("key")
  public String getKey() {
    return key;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("enabled")
  public boolean getEnabled() {
    return enabled;
  }

  @JsonProperty("createdAt")
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty("updatedAt")
  public String getUpdatedAt() {
    return updatedAt;
  }

  @JsonProperty("variants")
  public List<FliptVariant> getVariants() {
    return variants;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FliptFlag && equalTo((FliptFlag) other);
  }

  private boolean equalTo(FliptFlag other) {
    return key.equals(other.key) && name.equals(other.name) && description.equals(other.description) && enabled == other.enabled && createdAt.equals(other.createdAt) && updatedAt.equals(other.updatedAt) && variants.equals(other.variants);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.key, this.name, this.description, this.enabled, this.createdAt, this.updatedAt, this.variants);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "FliptFlag{" + "key: " + key + ", name: " + name + ", description: " + description + ", enabled: " + enabled + ", createdAt: " + createdAt + ", updatedAt: " + updatedAt + ", variants: " + variants + "}";
  }

  public static KeyStage builder() {
    return new Builder();
  }

  public interface KeyStage {
    NameStage key(String key);

    Builder from(FliptFlag other);
  }

  public interface NameStage {
    DescriptionStage name(String name);
  }

  public interface DescriptionStage {
    EnabledStage description(String description);
  }

  public interface EnabledStage {
    CreatedAtStage enabled(boolean enabled);
  }

  public interface CreatedAtStage {
    UpdatedAtStage createdAt(String createdAt);
  }

  public interface UpdatedAtStage {
    _FinalStage updatedAt(String updatedAt);
  }

  public interface _FinalStage {
    FliptFlag build();

    _FinalStage variants(List<FliptVariant> variants);

    _FinalStage variants(FliptVariant variants);

    _FinalStage addAllVariants(List<FliptVariant> variants);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  static final class Builder implements KeyStage, NameStage, DescriptionStage, EnabledStage, CreatedAtStage, UpdatedAtStage, _FinalStage {
    private String key;

    private String name;

    private String description;

    private boolean enabled;

    private String createdAt;

    private String updatedAt;

    private List<FliptVariant> variants = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(FliptFlag other) {
      key(other.getKey());
      name(other.getName());
      description(other.getDescription());
      enabled(other.getEnabled());
      createdAt(other.getCreatedAt());
      updatedAt(other.getUpdatedAt());
      variants(other.getVariants());
      return this;
    }

    @Override
    @JsonSetter("key")
    public NameStage key(String key) {
      this.key = key;
      return this;
    }

    @Override
    @JsonSetter("name")
    public DescriptionStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    @JsonSetter("description")
    public EnabledStage description(String description) {
      this.description = description;
      return this;
    }

    @Override
    @JsonSetter("enabled")
    public CreatedAtStage enabled(boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    @Override
    @JsonSetter("createdAt")
    public UpdatedAtStage createdAt(String createdAt) {
      this.createdAt = createdAt;
      return this;
    }

    @Override
    @JsonSetter("updatedAt")
    public _FinalStage updatedAt(String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    @Override
    public _FinalStage addAllVariants(List<FliptVariant> variants) {
      this.variants.addAll(variants);
      return this;
    }

    @Override
    public _FinalStage variants(FliptVariant variants) {
      this.variants.add(variants);
      return this;
    }

    @Override
    @JsonSetter(
        value = "variants",
        nulls = Nulls.SKIP
    )
    public _FinalStage variants(List<FliptVariant> variants) {
      this.variants.clear();
      this.variants.addAll(variants);
      return this;
    }

    @Override
    public FliptFlag build() {
      return new FliptFlag(key, name, description, enabled, createdAt, updatedAt, variants);
    }
  }
}
