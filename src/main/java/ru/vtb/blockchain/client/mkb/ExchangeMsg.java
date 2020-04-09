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


import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import java.io.File;
import javax.net.ssl.SSLException;

public class ExchangeMsg implements IHandlerTextInput, IHandlerExit {
    private static final String trustCertCollectionFilePath = "./ca.pem";

    private static final String clientCertChainFilePath = "./client.pem";

    private static final String clientPrivateKeyFilePath = "./client.key";

    public static final Logger logger = LoggerFactory.getLogger(ExchangeMsg.class);

    private String target = "localhost:50051";

    ManagedChannel channel;

    private final AuthorizationGrpc.AuthorizationBlockingStub blockingStub;

    public ExchangeMsg() throws SSLException {
        logger.info("Start");

        ManagedChannel cn = NettyChannelBuilder.forAddress("localhost", 50051)
//            .overrideAuthority("localhost")
//            .overrideAuthority("foo.test.google.fr")
            .sslContext(buildSslContext(trustCertCollectionFilePath, clientCertChainFilePath, clientPrivateKeyFilePath))
            .build();

        channel = cn;

//        channel = ManagedChannelBuilder.forTarget(target)
//            .usePlaintext()
//            .build();

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

    private static SslContext buildSslContext(String trustCertCollectionFilePath,
        String clientCertChainFilePath,
        String clientPrivateKeyFilePath) throws SSLException {
        SslContextBuilder builder = GrpcSslContexts.forClient();
        if (trustCertCollectionFilePath != null) {
            builder.trustManager(new File(trustCertCollectionFilePath));
        }
        if (clientCertChainFilePath != null && clientPrivateKeyFilePath != null) {
            builder.keyManager(new File(clientCertChainFilePath), new File(clientPrivateKeyFilePath));
        }
        return builder.build();
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
