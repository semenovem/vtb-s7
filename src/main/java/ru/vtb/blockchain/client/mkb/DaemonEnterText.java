package ru.vtb.blockchain.client.mkb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vtb.blockchain.IHandlerExit;
import ru.vtb.blockchain.IHandlerTextInput;

public class DaemonEnterText extends Thread {
    public static final Logger logger = LoggerFactory.getLogger(ExchangeMsg.class);

    public interface IHandlers extends IHandlerTextInput, IHandlerExit {}

    private final IHandlers handlers;

    public volatile boolean isExit = false;

    public DaemonEnterText(IHandlers handlers) {
        this.handlers = handlers;
        super.setDaemon(true);
    }

    @Override
    public void run() {
        super.run();

        try {
            startWork();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("failed start stream of keyboard ", e);
        }
    }

    /**
     * @deprecated - todo использовать ru.vtb.blockchain.HandlerConsoleTextInput
     */
    private void startWork() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!isInterrupted() && isAlive()) {
            String s = reader.readLine();

            if (s.trim().equals("exit")) {
                handlers.exit();
                break;
            }

            handlers.inputText(s);
        }
        reader.close();

        isExit = true;
    }
}
