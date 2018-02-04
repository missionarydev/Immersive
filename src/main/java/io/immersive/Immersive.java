package io.immersive;

import io.immersive.server.Server;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Immersive {
    @Getter private static Logger logger;
    @Getter private static Server server;

    private static boolean instated;

    public static void main(final String[] args) {
        if(instated)
            return;

        new Immersive();

        instated = true;
    }

    @SneakyThrows(IOException.class)
    private Immersive() {
        LogManager.getLogManager().readConfiguration(this.getClass().getClassLoader().getResourceAsStream("logging.properties"));

        logger = Logger.getLogger("Immersive");
        server = new Server();
    }
}
