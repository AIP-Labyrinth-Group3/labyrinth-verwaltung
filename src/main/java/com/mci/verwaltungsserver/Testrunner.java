package com.mci.verwaltungsserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mci.verwaltungsserver.api.ServersApiController;
import com.mci.verwaltungsserver.model.GameServerRegistration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Testrunner implements CommandLineRunner {

    private final ServersApiController serversApiController;

    public Testrunner(ServersApiController serversApiController) {
        this.serversApiController = serversApiController;
    }

    @Override
    public void run(String... args) throws Exception {

        //get list of Servers
        System.out.println("Creat New Gameserver:");
        GameServerRegistration gameServerRegistration = new GameServerRegistration();
        gameServerRegistration.setName("Test Server");
        gameServerRegistration.setUri("ws://localhost:9000");
        gameServerRegistration.setMaxPlayers(4);
        serversApiController.createServer(gameServerRegistration);


        System.out.println("Creat New Gameserver 2:");
        gameServerRegistration.setName("Test Server2 ");
        gameServerRegistration.setUri("ws://localhost:9090");
        gameServerRegistration.setMaxPlayers(3);
        serversApiController.createServer(gameServerRegistration);


    }
}