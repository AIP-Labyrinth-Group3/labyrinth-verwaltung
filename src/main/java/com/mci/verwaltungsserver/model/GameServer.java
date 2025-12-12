package com.mci.verwaltungsserver.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * GameServer
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-22T21:46:15.546784600+01:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class GameServer {

  private String name;

  private String uri;

  private Integer maxPlayers;

  private Integer currentPlayerCount;
/*
  /**
   * Current game state:   - `LOBBY`: Waiting for players to join   - `IN_GAME`: Game is currently running   - `FINISHED`: Game has ended 
   */
    /*
  public enum StatusEnum {
    LOBBY("LOBBY"),
    
    IN_GAME("IN_GAME"),
    
    FINISHED("FINISHED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }
*/
  private ServerStatusEnum status;

  private String id;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastSeen;

  public GameServer() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GameServer(String name, String uri, Integer maxPlayers, Integer currentPlayerCount, ServerStatusEnum status, String id, OffsetDateTime lastSeen) {
    this.name = name;
    this.uri = uri;
    this.maxPlayers = maxPlayers;
    this.currentPlayerCount = currentPlayerCount;
    this.status = status;
    this.id = id;
    this.lastSeen = lastSeen;
  }

  public GameServer name(String name) {
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

  public GameServer uri(String uri) {
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

  public GameServer maxPlayers(Integer maxPlayers) {
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

  public GameServer currentPlayerCount(Integer currentPlayerCount) {
    this.currentPlayerCount = currentPlayerCount;
    return this;
  }

  /**
   * Get currentPlayerCount
   * @return currentPlayerCount
  */
  @NotNull 
  @Schema(name = "currentPlayerCount", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("currentPlayerCount")
  public Integer getCurrentPlayerCount() {
    return currentPlayerCount;
  }

  public void setCurrentPlayerCount(Integer currentPlayerCount) {
    this.currentPlayerCount = currentPlayerCount;
  }

  public GameServer status(ServerStatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Current game state:   - `LOBBY`: Waiting for players to join   - `IN_GAME`: Game is currently running   - `FINISHED`: Game has ended 
   * @return status
  */
  @NotNull 
  @Schema(name = "status", example = "LOBBY", description = "Current game state:   - `LOBBY`: Waiting for players to join   - `IN_GAME`: Game is currently running   - `FINISHED`: Game has ended ", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public ServerStatusEnum getStatus() {
    return status;
  }

  public void setStatus(ServerStatusEnum status) {
    this.status = status;
  }

  public GameServer id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull @Valid 
  @Schema(name = "id", example = "d290f1ee-6c54-4b01-90e6-d701748f0851", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GameServer lastSeen(OffsetDateTime lastSeen) {
    this.lastSeen = lastSeen;
    return this;
  }

  /**
   * Get lastSeen
   * @return lastSeen
  */
  @NotNull @Valid 
  @Schema(name = "lastSeen", example = "2025-10-07T14:12Z", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastSeen")
  public OffsetDateTime getLastSeen() {
    return lastSeen;
  }

  public void setLastSeen(OffsetDateTime lastSeen) {
    this.lastSeen = lastSeen;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameServer gameServer = (GameServer) o;
    return Objects.equals(this.name, gameServer.name) &&
        Objects.equals(this.uri, gameServer.uri) &&
        Objects.equals(this.maxPlayers, gameServer.maxPlayers) &&
        Objects.equals(this.currentPlayerCount, gameServer.currentPlayerCount) &&
        Objects.equals(this.status, gameServer.status) &&
        Objects.equals(this.id, gameServer.id) &&
        Objects.equals(this.lastSeen, gameServer.lastSeen);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, uri, maxPlayers, currentPlayerCount, status, id, lastSeen);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameServer {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    maxPlayers: ").append(toIndentedString(maxPlayers)).append("\n");
    sb.append("    currentPlayerCount: ").append(toIndentedString(currentPlayerCount)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    lastSeen: ").append(toIndentedString(lastSeen)).append("\n");
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

