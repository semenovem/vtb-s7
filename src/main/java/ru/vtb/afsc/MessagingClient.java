package ru.vtb.afsc;

import java.io.Closeable;
import ru.vtb.afsc.mon.Monitorable;

public interface MessagingClient extends Closeable, Monitorable {

    long POLL_TIMEOUT_IN_MILLIS = 100;

    default long getPollTimeoutInMillis() {
        return POLL_TIMEOUT_IN_MILLIS;
    }

    String getName();

    MessagingClient connect();

    String poll() throws InterruptedException;

    void offer (String message);

    @Override
    default void close() {
        // noop
        System.out.println(MessagingClient.class + " >> close");
    }
}
