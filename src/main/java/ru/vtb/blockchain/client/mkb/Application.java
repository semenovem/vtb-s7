package ru.vtb.blockchain.client.mkb;

import java.security.KeyStoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    public static final Logger logger = LoggerFactory.getLogger(ExchangeMsg.class);

    public static void main(String[] args) {
        ExchangeMsg exchangeMsg = new ExchangeMsg();
        DaemonEnterText keyDaemon = new DaemonEnterText(new AdapterExchangeMsgToDaemonEnterText(exchangeMsg));

        try {
            Encryption encryption = new Encryption();
        } catch (KeyStoreException e) {
            logger.error("failed init KeyStore. Message: {}", e.getMessage());
        }

        keyDaemon.start();

        while (!keyDaemon.isExit) {
            Thread.yield();
        }
    }
}
