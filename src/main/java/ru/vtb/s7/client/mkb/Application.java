package ru.vtb.s7.client.mkb;

import javax.net.ssl.SSLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    public static final Logger logger = LoggerFactory.getLogger(ExchangeMsg.class);

    public static void main(String[] args) throws SSLException {
        ExchangeMsg exchangeMsg = new ExchangeMsg();
        DaemonEnterText keyDaemon = new DaemonEnterText(new AdapterExchangeMsgToDaemonEnterText(exchangeMsg));

        keyDaemon.start();

        while (!keyDaemon.isExit) {
            Thread.yield();
        }
    }
}
