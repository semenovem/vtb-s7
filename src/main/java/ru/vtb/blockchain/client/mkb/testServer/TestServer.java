package ru.vtb.blockchain.client.mkb.testServer;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vtb.blockchain.client.mkb.ExchangeMsg;

public class TestServer {
    public static final Logger logger = LoggerFactory.getLogger(ExchangeMsg.class);

    public static final int defaultPort = 50051;

    public static final int maxPort = 65535;

    public static void main(String[] args) {
        int port;

        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);

                if (port > maxPort) {
                    logger.error("Specified port {} can't be more than {}", port, defaultPort);
                    System.exit(1);
                    return;
                }

                if (port < 0) {
                    logger.error("Specified port {} can't be negative", port);
                    System.exit(1);
                    return;
                }


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
