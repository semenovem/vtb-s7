package ru.vtb.s7.client.mkb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.AdditionalAnswers.delegatesTo;
import static org.mockito.Mockito.verify;

import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import io.grpc.ManagedChannel;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.testing.GrpcCleanupRule;

import ru.vtb.s7.client.mkb.grpc.AuthorizationGrpc;
import ru.vtb.s7.client.mkb.grpc.AuthorizationRequest;
import ru.vtb.s7.client.mkb.grpc.AuthorizationReply;

public class ExchangeMsgTest {
    @Rule
    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();

    private final AuthorizationGrpc.AuthorizationImplBase serviceImpl =
        mock(AuthorizationGrpc.AuthorizationImplBase.class, delegatesTo(
            new AuthorizationGrpc.AuthorizationImplBase() {
                // By default the client will receive Status.UNIMPLEMENTED for all RPCs.
                // You might need to implement necessary behaviors for your test here, like this:
                //
                // @Override
                // public void sayHello(HelloRequest request, StreamObserver<HelloReply> respObserver) {
                //   respObserver.onNext(HelloReply.getDefaultInstance());
                //   respObserver.onCompleted();
                // }
            }));

    private ExchangeMsg client;


    @Before
    public void setUp() throws Exception {
        // Generate a unique in-process server name.
        String serverName = InProcessServerBuilder.generateName();

        // Create a server, add service, start, and register for automatic graceful shutdown.
        grpcCleanup.register(InProcessServerBuilder
            .forName(serverName).directExecutor().addService(serviceImpl).build().start());

        // Create a client channel and register for automatic graceful shutdown.
        ManagedChannel channel = grpcCleanup.register(
            InProcessChannelBuilder.forName(serverName).directExecutor().build());

        // Create a HelloWorldClient using the in-process channel;
        client = new ExchangeMsg(channel);
    }

    @Test
    @DisplayName("client check Authorization")
    public void testAuthorization() {
        ArgumentCaptor<AuthorizationRequest> requestCaptor = ArgumentCaptor.forClass(AuthorizationRequest.class);

        client.greet("test name");

        verify(serviceImpl)
            .sayHello(requestCaptor.capture(), ArgumentMatchers.<StreamObserver<AuthorizationReply>>any());
        assertEquals("test name", requestCaptor.getValue().getName());
    }
}
