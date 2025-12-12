package com.mci.verwaltungsserver;

import com.mci.verwaltungsserver.api.ServersApiController;
import com.mci.verwaltungsserver.model.GameServerRegistration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VerwaltungsserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerwaltungsserverApplication.class, args);
    }
    @Bean
    CommandLineRunner run() {
        return args -> {
            System.out.println("Verwaltungsserver gestartet...");
            ServersApiController serversApiController = new ServersApiController();

            GameServerRegistration gameServerRegistration = new GameServerRegistration();
            gameServerRegistration.setName("Test Server");
            gameServerRegistration.setUri("http://localhost:9000");
            gameServerRegistration.setMaxPlayers(4);
            serversApiController.createServer(gameServerRegistration);

            gameServerRegistration.setName("Test Server2");
            gameServerRegistration.setUri("http://localhost:8081");
            gameServerRegistration.setMaxPlayers(3);

        };


    }
}
