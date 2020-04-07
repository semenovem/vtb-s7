package ru.vtb.blockchain.client.mkb.testServer;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vtb.blockchain.client.mkb.ExchangeMsg;

public class TestServer {
    public static final Logger logger = LoggerFactory.getLogger(ExchangeMsg.class);

    public static void main(String[] args) {
        try {
            WrapServer wrapServer = new WrapServer();

            logger.info("Server is running");

            wrapServer.blockUntilShutdown();
        } catch (IOException e) {
            logger.error("Error trying to start server", e);
        }
    }
}
