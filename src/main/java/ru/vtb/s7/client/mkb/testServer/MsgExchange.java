package ru.vtb.s7.client.mkb.testServer;

import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.SslContextBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.netty.GrpcSslContexts;
import java.io.IOException;
import io.grpc.stub.StreamObserver;
import io.grpc.Server;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vtb.s7.client.mkb.ExchangeMsg;
//import ru.vtb.s7.client.mkb.grpc.AuthorizationGrpc;
//import ru.vtb.s7.client.mkb.grpc.AuthorizationRequest;
//import ru.vtb.s7.client.mkb.grpc.AuthorizationReply;

// импорт из пакета
import ru.vtb.grpc.mbank.adapter.RegistryGrpc;
import ru.vtb.grpc.mbank.adapter.AccountRequest;
import ru.vtb.grpc.mbank.adapter.AccountReply;

public class MsgExchange {
    private static final Logger logger = LoggerFactory.getLogger(ExchangeMsg.class);

    private final Credential credential;

    Server server;

    MsgExchange(int port, Credential credential) throws IOException {
        this.credential = credential;

        logger.debug("start constructor for WrapServer");

        server = NettyServerBuilder.forPort(port)
            .addService(new RegistryImpl())
            .sslContext(getSslContextBuilder().build())
            .build()
            .start();

        logger.debug("Server started, listening on " + port);

        addRuntimeShutdownHook();
    }

    public void blockUntilShutdown() {
        try {
            if (server != null) {
                server.awaitTermination();
            }
        } catch (InterruptedException e) {
            logger.error("Interrupted thread of server ", e);
        }
    }

    private void addRuntimeShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.error("*** shutting down gRPC server since JVM is shutting down");
            try {
                MsgExchange.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            logger.error("*** server shut down");
        }));
    }

    private SslContextBuilder getSslContextBuilder() {
        SslContextBuilder sslClientContextBuilder = SslContextBuilder.forServer(
            credential.getCertChain(),
            credential.getPrivateKey()
        );

        sslClientContextBuilder.trustManager(credential.getTrustCertCollection());
        sslClientContextBuilder.clientAuth(ClientAuth.REQUIRE);

        return GrpcSslContexts.configure(sslClientContextBuilder);
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    static class RegistryImpl extends RegistryGrpc.RegistryImplBase {
        @Override
        public void getAccount(AccountRequest request, StreamObserver<AccountReply> responseObserver) {
            logger.debug("Received field `name`" + request.getName());

            System.out.println("");
            System.out.println("Received field `name`" + request.getName());
            System.out.println("");

            AccountReply reply = AccountReply.newBuilder().setMessage("Hello " + request.getName()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}
