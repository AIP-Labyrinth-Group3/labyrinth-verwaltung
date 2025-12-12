package com.mci.verwaltungsserver.api;

import com.mci.verwaltungsserver.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
public class ServersApiController implements ServersApi {

    // einfache In-Memory-Datenbank
    private final Map<UUID, GameServer> servers = new ConcurrentHashMap<>();

    @Override
    public ResponseEntity<List<GameServer>> listServers() {
        // aktuell: alle registrierten Server zurückgeben
        List<GameServer> list = new ArrayList<>(servers.values());
        System.out.println("Listing Servers: " + list.stream().map(GameServer::getId).collect(Collectors.joining(", ")));
        return ResponseEntity.ok(list);
    }

    @Override
    public ResponseEntity<GameServer> createServer(GameServerRegistration gameServerRegistration) {
        UUID id = UUID.randomUUID();

        GameServer server = new GameServer();
        // aus Registration
        server.setName(gameServerRegistration.getName());
        server.setUri(gameServerRegistration.getUri());
        server.setMaxPlayers(gameServerRegistration.getMaxPlayers());

        // aus Update-Teil (erstmal Default-Werte)
        server.setCurrentPlayerCount(0);
        server.setStatus(ServerStatusEnum.LOBBY);

        // zusätzliche Felder
        server.setId(id.toString());
        server.setLastSeen(OffsetDateTime.now());

        servers.put(id, server);
        System.out.println("Created Server: " + server.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(server);
    }

    @Override
    public ResponseEntity<GameServer> updateServer(String serverId, GameServerUpdate gameServerUpdate) {
        UUID uuid = UUID.fromString(serverId);
        GameServer existing = servers.get(uuid);
        if (existing == null) {
            // hier könntest du auch einen ErrorResponse bauen
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        existing.setCurrentPlayerCount(gameServerUpdate.getCurrentPlayerCount());
        existing.setStatus(gameServerUpdate.getStatus());
        existing.setLastSeen(OffsetDateTime.now());
        System.out.println("Updated Server: " + existing.getId());
        return ResponseEntity.ok(existing);
    }

    @Override
    public ResponseEntity<Void> deleteServer(UUID serverId) {
        GameServer removed = servers.remove(serverId);
        if (removed == null) {
            System.out.println("Server not found for deletion: " + serverId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        System.out.println("Deleted Server: " + removed.getId());
        return ResponseEntity.noContent().build();
    }
}