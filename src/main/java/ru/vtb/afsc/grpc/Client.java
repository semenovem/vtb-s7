package ru.vtb.afsc.grpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.grpc.StatusRuntimeException;
import ru.vtb.grpc.mbank.adapter.AccountReply;
import ru.vtb.grpc.mbank.adapter.AccountRequest;
import ru.vtb.grpc.mbank.adapter.RegistryGrpc;

import ru.vtb.afsc.MessagingClient;

/**
 * Клиент для передачи данных с помощью grpc
 */
public class Client implements MessagingClient {

    public static final String NAME = "GRPC_CLIENT";

    private static final Logger LOG = LoggerFactory.getLogger(Client.class);

    private ConnectionToServer connect;

    private RegistryGrpc.RegistryBlockingStub blockingStub;

    @Override
    public String getName() {
        return NAME;
    }


    /**
     * Подключение клиентом к серверу (к абс мбанка)
     */
    @Override
    public synchronized MessagingClient connect() {
        try {
            connect = new ConnectionToServer();

            // todo можно сделать дженериком и убрать channel внутрь connectionToServer
            blockingStub = RegistryGrpc.newBlockingStub(connect.getChannel());

            return this;
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }



    /**
     * Вызов со стороны блокчейна - забрать очередное обработанное сообщение
     */
    @Override
    public synchronized String poll() throws InterruptedException {
        System.out.println("pool");
        // превратить dto в xml
        // положить в очередь
        return null;
    }



    /**
     * Вызов со стороны блокчейна - положить сообщение для отправки
     */
    @Override
    public synchronized void offer(final String payload) {
        System.out.println("offer");

        // преобразование xml в java класс
        // определить, какой dto передан

        AccountRequest request = AccountRequest.newBuilder().setName(payload).build();
        AccountReply response;

        try {
            response = blockingStub.getAccount(request);

            System.out.println("Greeting123: " + response.getMessage());

        } catch (StatusRuntimeException ex) {
            System.out.println(ex.getStatus());
        }
    }



    @Override
    public void reset() {
        System.out.println("reset");
    }

    @Override
    public void close() {
        if (connect != null) {
            connect.close();
        }
    }

    @Override
    public String toString() {
        return NAME;
    }
}
