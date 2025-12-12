package com.mci.verwaltungsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * GameServerRegistration
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-22T21:46:15.546784600+01:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class GameServerRegistration {

  private String name;

  private String uri;

  private Integer maxPlayers;

  public GameServerRegistration() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GameServerRegistration(String name, String uri, Integer maxPlayers) {
    this.name = name;
    this.uri = uri;
    this.maxPlayers = maxPlayers;
  }

  public GameServerRegistration name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "MCI Pro Labyrinth", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GameServerRegistration uri(String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * Get uri
   * @return uri
  */
  @NotNull 
  @Schema(name = "uri", example = "ws://play.example.com:9000", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("uri")
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public GameServerRegistration maxPlayers(Integer maxPlayers) {
    this.maxPlayers = maxPlayers;
    return this;
  }

  /**
   * Get maxPlayers
   * @return maxPlayers
  */
  @NotNull 
  @Schema(name = "maxPlayers", example = "4", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("maxPlayers")
  public Integer getMaxPlayers() {
    return maxPlayers;
  }

  public void setMaxPlayers(Integer maxPlayers) {
    this.maxPlayers = maxPlayers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameServerRegistration gameServerRegistration = (GameServerRegistration) o;
    return Objects.equals(this.name, gameServerRegistration.name) &&
        Objects.equals(this.uri, gameServerRegistration.uri) &&
        Objects.equals(this.maxPlayers, gameServerRegistration.maxPlayers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, uri, maxPlayers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameServerRegistration {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    maxPlayers: ").append(toIndentedString(maxPlayers)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

