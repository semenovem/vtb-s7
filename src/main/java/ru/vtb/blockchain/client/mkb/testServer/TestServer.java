package ru.vtb.blockchain.client.mkb.testServer;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vtb.blockchain.client.mkb.ExchangeMsg;

public class TestServer {
    public static final Logger logger = LoggerFactory.getLogger(ExchangeMsg.class);

    public static final int defaultPort = 50051;

    public static void main(String[] args) {
        int port;

        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {
                port = defaultPort;
            }
        } else {
            port = defaultPort;
        }

        try {
            WrapServer wrapServer = new WrapServer(port);

            wrapServer.blockUntilShutdown();
        } catch (IOException e) {
            logger.error("Error trying to start server", e);
        }
    }
}
