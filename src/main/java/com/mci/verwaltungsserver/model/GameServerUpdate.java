package com.mci.verwaltungsserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * GameServerUpdate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-22T21:46:15.546784600+01:00[Europe/Vienna]", comments = "Generator version: 7.5.0")
public class GameServerUpdate {

  private Integer currentPlayerCount;

  /**
   * Current game state:   - `LOBBY`: Waiting for players to join   - `IN_GAME`: Game is currently running   - `FINISHED`: Game has ended
  **/

  public ServerStatusEnum status;
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

  private StatusEnum status;
*/
  public GameServerUpdate() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GameServerUpdate(Integer currentPlayerCount, ServerStatusEnum status) {
    this.currentPlayerCount = currentPlayerCount;
    this.status = status;
  }

  public GameServerUpdate currentPlayerCount(Integer currentPlayerCount) {
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

  public GameServerUpdate status(ServerStatusEnum status) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameServerUpdate gameServerUpdate = (GameServerUpdate) o;
    return Objects.equals(this.currentPlayerCount, gameServerUpdate.currentPlayerCount) &&
        Objects.equals(this.status, gameServerUpdate.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPlayerCount, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GameServerUpdate {\n");
    sb.append("    currentPlayerCount: ").append(toIndentedString(currentPlayerCount)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

