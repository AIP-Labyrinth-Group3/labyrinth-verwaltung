package com.mci.verwaltungsserver.api;

import com.mci.verwaltungsserver.model.ErrorResponse;
import com.mci.verwaltungsserver.model.GameServer;
import com.mci.verwaltungsserver.model.GameServerRegistration;
import com.mci.verwaltungsserver.model.GameServerUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

@Validated
@Tag(
        name = "Servers",
        description = "Endpoints for registering, updating, discovering, and removing game servers."
)
public interface ServersApi {
    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @Operation(
            operationId = "createServer",
            summary = "Register a new game server",
            tags = {"Servers"},
            responses = {@ApiResponse(
                    responseCode = "201",
                    description = "Server successfully registered.",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = GameServer.class
                            )
                    )}
            ), @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request data.",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )}
            )}
    )
    @RequestMapping(
            method = {RequestMethod.POST},
            value = {"/servers"},
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    default ResponseEntity<GameServer> createServer(@Parameter(name = "GameServerRegistration",description = "The initial configuration and contact information for the new game server.",required = true) @RequestBody @Valid GameServerRegistration gameServerRegistration) {
        this.getRequest().ifPresent((request) -> {
            for(MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"currentPlayerCount\" : 2, \"maxPlayers\" : 4, \"lastSeen\" : \"2025-10-07T14:12:00Z\", \"name\" : \"MCI Pro Labyrinth\", \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\", \"uri\" : \"ws://play.example.com:9000\", \"status\" : \"LOBBY\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }

                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 404, \"message\" : \"Server not found\", \"timestamp\" : \"2025-10-07T14:15:23Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }

        });
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            operationId = "deleteServer",
            summary = "Unregister a game server",
            tags = {"Servers"},
            responses = {@ApiResponse(
                    responseCode = "204",
                    description = "Server successfully unregistered."
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Server not found.",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )}
            )}
    )
    @RequestMapping(
            method = {RequestMethod.DELETE},
            value = {"/servers/{serverId}"},
            produces = {"application/json"}
    )
    default ResponseEntity<Void> deleteServer(@Parameter(name = "serverId",description = "Unique identifier of the game server.",required = true,in = ParameterIn.PATH) @PathVariable("serverId") UUID serverId) {
        this.getRequest().ifPresent((request) -> {
            for(MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 404, \"message\" : \"Server not found\", \"timestamp\" : \"2025-10-07T14:15:23Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }

        });
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            operationId = "listServers",
            summary = "Retrieve active game servers",
            description = "Fetch a list of all currently registered and active game servers. A server is considered active if it has sent a heartbeat within the configured time frame. ",
            tags = {"Servers"},
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Successful response containing an array of game server objects.",
                    content = {@Content(
                            mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(
                                            implementation = GameServer.class
                                    )
                            )
                    )}
            ), @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error.",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )}
            )}
    )
    @RequestMapping(
            method = {RequestMethod.GET},
            value = {"/servers"},
            produces = {"application/json"}
    )
    default ResponseEntity<List<GameServer>> listServers() {
        this.getRequest().ifPresent((request) -> {
            for(MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"currentPlayerCount\" : 2, \"maxPlayers\" : 4, \"lastSeen\" : \"2025-10-07T14:12:00Z\", \"name\" : \"MCI Pro Labyrinth\", \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\", \"uri\" : \"ws://play.example.com:9000\", \"status\" : \"LOBBY\" }, { \"currentPlayerCount\" : 2, \"maxPlayers\" : 4, \"lastSeen\" : \"2025-10-07T14:12:00Z\", \"name\" : \"MCI Pro Labyrinth\", \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\", \"uri\" : \"ws://play.example.com:9000\", \"status\" : \"LOBBY\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }

                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 404, \"message\" : \"Server not found\", \"timestamp\" : \"2025-10-07T14:15:23Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }

        });
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(
            operationId = "updateServer",
            summary = "Update server status (heartbeat)",
            tags = {"Servers"},
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Server successfully updated.",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = GameServer.class
                            )
                    )}
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Server not found.",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ErrorResponse.class
                            )
                    )}
            )}
    )
    @RequestMapping(
            method = {RequestMethod.PUT},
            value = {"/servers/{serverId}"},
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    default ResponseEntity<GameServer> updateServer(@Parameter(name = "serverId",description = "Unique identifier of the game server.",required = true,in = ParameterIn.PATH) @PathVariable("serverId") String serverId, @Parameter(name = "GameServerUpdate",description = "Partial update object containing dynamic state fields.",required = true) @RequestBody @Valid GameServerUpdate gameServerUpdate) {
        this.getRequest().ifPresent((request) -> {
            for(MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"currentPlayerCount\" : 2, \"maxPlayers\" : 4, \"lastSeen\" : \"2025-10-07T14:12:00Z\", \"name\" : \"MCI Pro Labyrinth\", \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\", \"uri\" : \"ws://play.example.com:9000\", \"status\" : \"LOBBY\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }

                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 404, \"message\" : \"Server not found\", \"timestamp\" : \"2025-10-07T14:15:23Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }

        });
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }
}
