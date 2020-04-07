package ru.vtb.blockchain.client.mkb;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import ru.vtb.blockchain.IHandlerExit;
import ru.vtb.blockchain.IHandlerTextInput;
import ru.vtb.blockchain.client.mkb.grpc.AuthorizationGrpc;
import ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest;
import ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExchangeMsg implements IHandlerTextInput, IHandlerExit {
    public static final Logger logger = LoggerFactory.getLogger(ExchangeMsg.class);

    private String target = "localhost:50051";

    ManagedChannel channel;

    private final AuthorizationGrpc.AuthorizationBlockingStub blockingStub;

    public ExchangeMsg() {
        logger.info("Start");

        channel = ManagedChannelBuilder.forTarget(target)
            .usePlaintext()
            .build();

        blockingStub = AuthorizationGrpc.newBlockingStub(channel);
    }

    @Override
    public void inputText(String str) {
        logger.debug("input text: " + str);

        greet(str);
    }

    @Override
    public void exit() {
        logger.debug("stop work");

        try {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            logger.error("Failed to shutdown of channel", e);
        }
    }


    private void greet(String name) {
        AuthorizationRequest request = AuthorizationRequest.newBuilder().setName(name).build();
        AuthorizationReply response;
        try {
            response = blockingStub.sayHello(request);
        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus());
            return;
        }

        // TODO обработка ответа

        System.out.println("Greeting: " + response.getMessage());
    }
}
