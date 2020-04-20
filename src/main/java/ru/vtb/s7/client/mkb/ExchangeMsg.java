package ru.vtb.s7.client.mkb;

import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import ru.vtb.s7.IHandlerExit;
import ru.vtb.s7.IHandlerTextInput;
//import ru.vtb.s7.client.mkb.grpc.AuthorizationGrpc;
//import ru.vtb.s7.client.mkb.grpc.AuthorizationRequest;
//import ru.vtb.s7.client.mkb.grpc.AuthorizationReply;

// импорт из пакета
import ru.vtb.grpc.mbank.adapter.RegistryGrpc;
import ru.vtb.grpc.mbank.adapter.AccountRequest;
import ru.vtb.grpc.mbank.adapter.AccountReply;

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

    private final ManagedChannel channel;

    private final RegistryGrpc.RegistryBlockingStub blockingStub;

    ExchangeMsg() throws SSLException {
        logger.debug("Start client");

        ManagedChannel cn = NettyChannelBuilder.forAddress("localhost", 50051)
//            .overrideAuthority("localhost")
            .sslContext(buildSslContext(trustCertCollectionFilePath, clientCertChainFilePath, clientPrivateKeyFilePath))
            .build();

        channel = cn;

//        channel = ManagedChannelBuilder.forTarget(target)
//            .usePlaintext()
//            .build();

        blockingStub = RegistryGrpc.newBlockingStub(channel);
    }

    ExchangeMsg(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = RegistryGrpc.newBlockingStub(channel);
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


    void greet(String name) {
        AccountRequest request = AccountRequest.newBuilder().setName(name).build();
        AccountReply response;

        try {
            response = blockingStub.getAccount(request);
        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus());
            return;
        }

        // TODO обработка ответа

        System.out.println("Greeting: " + response.getMessage());
    }
}
