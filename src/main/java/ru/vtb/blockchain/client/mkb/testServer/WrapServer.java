package ru.vtb.blockchain.client.mkb.testServer;

import java.io.IOException;
import io.grpc.stub.StreamObserver;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vtb.blockchain.client.mkb.ExchangeMsg;
import ru.vtb.blockchain.client.mkb.grpc.AuthorizationGrpc;
import ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest;
import ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply;


public class WrapServer {
    public static final Logger logger = LoggerFactory.getLogger(ExchangeMsg.class);
    Server server;

    public WrapServer() throws IOException {
        logger.info("start constructor for WrapServer");

        int port = 50051;
        server = ServerBuilder.forPort(port)
            .addService(new AuthorizationImpl())
            .build()
            .start();

        logger.info("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                logger.error("*** shutting down gRPC server since JVM is shutting down");
                try {
                    WrapServer.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                logger.error("*** server shut down");
            }
        });
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

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    static class AuthorizationImpl extends AuthorizationGrpc.AuthorizationImplBase {
        @Override
        public void sayHello(AuthorizationRequest request, StreamObserver<AuthorizationReply> responseObserver) {
            logger.debug("Received field `name`" + request.getName());

            AuthorizationReply reply = AuthorizationReply.newBuilder().setMessage("Hello " + request.getName()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }

}