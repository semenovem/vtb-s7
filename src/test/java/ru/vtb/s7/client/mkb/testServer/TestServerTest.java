//package ru.vtb.s7.client.mkb.testServer;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.io.IOException;
//import org.junit.Rule;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import io.grpc.testing.GrpcCleanupRule;
//import io.grpc.inprocess.InProcessServerBuilder;
//import io.grpc.inprocess.InProcessChannelBuilder;
//
////import ru.vtb.s7.client.mkb.grpc.AuthorizationGrpc;
////import ru.vtb.s7.client.mkb.grpc.AuthorizationRequest;
////import ru.vtb.s7.client.mkb.grpc.AuthorizationReply;
//
//// импорт из пакета
//import ru.vtb.grpc.mbank.adapter.AuthorizationGrpc;
//import ru.vtb.grpc.mbank.adapter.AuthorizationRequest;
//import ru.vtb.grpc.mbank.adapter.AuthorizationReply;
//
//
//import ru.vtb.s7.client.mkb.testServer.MsgExchange.AuthorizationImpl;
//
//public class TestServerTest {
//    @Rule
//    public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();
//
//    @Test
//    @DisplayName("server check Authorization")
//    public void test() throws IOException {
//        String serverName = InProcessServerBuilder.generateName();
//
//        grpcCleanup.register(
//            InProcessServerBuilder
//                .forName(serverName)
//                .directExecutor()
//                .addService(new AuthorizationImpl())
//                .build()
//                .start()
//        );
//
//        AuthorizationGrpc.AuthorizationBlockingStub blockingStub = AuthorizationGrpc.newBlockingStub(
//            grpcCleanup.register(InProcessChannelBuilder.forName(serverName).directExecutor().build())
//        );
//
//
//        AuthorizationReply reply =
//            blockingStub.sayHello(AuthorizationRequest.newBuilder().setName( "test name").build());
//
//        assertEquals("Hello test name", reply.getMessage());
//    }
//}
