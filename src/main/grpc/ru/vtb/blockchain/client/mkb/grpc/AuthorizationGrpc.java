package ru.vtb.blockchain.client.mkb.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.0)",
    comments = "Source: authorizationService.proto")
public final class AuthorizationGrpc {

  private AuthorizationGrpc() {}

  public static final String SERVICE_NAME = "Authorization";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest,
      ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest.class,
      responseType = ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest,
      ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest, ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply> getSayHelloMethod;
    if ((getSayHelloMethod = AuthorizationGrpc.getSayHelloMethod) == null) {
      synchronized (AuthorizationGrpc.class) {
        if ((getSayHelloMethod = AuthorizationGrpc.getSayHelloMethod) == null) {
          AuthorizationGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest, ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply.getDefaultInstance()))
              .setSchemaDescriptor(new AuthorizationMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthorizationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthorizationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthorizationStub>() {
        @java.lang.Override
        public AuthorizationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthorizationStub(channel, callOptions);
        }
      };
    return AuthorizationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthorizationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthorizationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthorizationBlockingStub>() {
        @java.lang.Override
        public AuthorizationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthorizationBlockingStub(channel, callOptions);
        }
      };
    return AuthorizationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthorizationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthorizationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthorizationFutureStub>() {
        @java.lang.Override
        public AuthorizationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthorizationFutureStub(channel, callOptions);
        }
      };
    return AuthorizationFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AuthorizationImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest request,
        io.grpc.stub.StreamObserver<ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest,
                ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply>(
                  this, METHODID_SAY_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class AuthorizationStub extends io.grpc.stub.AbstractAsyncStub<AuthorizationStub> {
    private AuthorizationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthorizationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthorizationStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest request,
        io.grpc.stub.StreamObserver<ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuthorizationBlockingStub extends io.grpc.stub.AbstractBlockingStub<AuthorizationBlockingStub> {
    private AuthorizationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthorizationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthorizationBlockingStub(channel, callOptions);
    }

    /**
     */
    public ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply sayHello(ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuthorizationFutureStub extends io.grpc.stub.AbstractFutureStub<AuthorizationFutureStub> {
    private AuthorizationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthorizationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthorizationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply> sayHello(
        ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthorizationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthorizationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((ru.vtb.blockchain.client.mkb.grpc.AuthorizationRequest) request,
              (io.grpc.stub.StreamObserver<ru.vtb.blockchain.client.mkb.grpc.AuthorizationReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AuthorizationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthorizationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ru.vtb.blockchain.client.mkb.grpc.AuthorizationService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Authorization");
    }
  }

  private static final class AuthorizationFileDescriptorSupplier
      extends AuthorizationBaseDescriptorSupplier {
    AuthorizationFileDescriptorSupplier() {}
  }

  private static final class AuthorizationMethodDescriptorSupplier
      extends AuthorizationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthorizationMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AuthorizationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthorizationFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
