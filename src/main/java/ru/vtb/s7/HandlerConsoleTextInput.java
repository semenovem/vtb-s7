package ru.vtb.s7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HandlerConsoleTextInput {
    private boolean enabled = false;

    private IHandlerExit handlerExit;

    private IHandlerTextInput handlerTextInput;

    public void start() throws IOException {
        if (enabled) {
            return;
        }

        enabled = true;
        launchReadingTextLines();
    }

    public void stop() {
        enabled = false;
    }

    public void setHandlerExit(IHandlerExit handlerExit) {
        this.handlerExit = handlerExit;
    }

    public void setHandlerTextInputLine(IHandlerTextInput handlerTextInput) {
        this.handlerTextInput = handlerTextInput;
    }

    private void launchReadingTextLines() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (enabled) {
            String s = reader.readLine();

            if (s.trim().equals("exit") && handlerExit != null) {
                handlerExit.exit();
                continue;
            }

            handlerTextInput.inputText(s);
        }

        reader.close();
    }
}
