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
    comments = "Source: connect.proto")
public final class ConnectGrpc {

  private ConnectGrpc() {}

  public static final String SERVICE_NAME = "ru.vtb.blockchain.client.mkb.grpc.Connect";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ru.vtb.blockchain.client.mkb.grpc.HelloRequest,
      ru.vtb.blockchain.client.mkb.grpc.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = ru.vtb.blockchain.client.mkb.grpc.HelloRequest.class,
      responseType = ru.vtb.blockchain.client.mkb.grpc.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ru.vtb.blockchain.client.mkb.grpc.HelloRequest,
      ru.vtb.blockchain.client.mkb.grpc.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<ru.vtb.blockchain.client.mkb.grpc.HelloRequest, ru.vtb.blockchain.client.mkb.grpc.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = ConnectGrpc.getSayHelloMethod) == null) {
      synchronized (ConnectGrpc.class) {
        if ((getSayHelloMethod = ConnectGrpc.getSayHelloMethod) == null) {
          ConnectGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<ru.vtb.blockchain.client.mkb.grpc.HelloRequest, ru.vtb.blockchain.client.mkb.grpc.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.vtb.blockchain.client.mkb.grpc.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.vtb.blockchain.client.mkb.grpc.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConnectStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConnectStub>() {
        @java.lang.Override
        public ConnectStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConnectStub(channel, callOptions);
        }
      };
    return ConnectStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConnectBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConnectBlockingStub>() {
        @java.lang.Override
        public ConnectBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConnectBlockingStub(channel, callOptions);
        }
      };
    return ConnectBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConnectFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConnectFutureStub>() {
        @java.lang.Override
        public ConnectFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConnectFutureStub(channel, callOptions);
        }
      };
    return ConnectFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ConnectImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(ru.vtb.blockchain.client.mkb.grpc.HelloRequest request,
        io.grpc.stub.StreamObserver<ru.vtb.blockchain.client.mkb.grpc.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ru.vtb.blockchain.client.mkb.grpc.HelloRequest,
                ru.vtb.blockchain.client.mkb.grpc.HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class ConnectStub extends io.grpc.stub.AbstractAsyncStub<ConnectStub> {
    private ConnectStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(ru.vtb.blockchain.client.mkb.grpc.HelloRequest request,
        io.grpc.stub.StreamObserver<ru.vtb.blockchain.client.mkb.grpc.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ConnectBlockingStub extends io.grpc.stub.AbstractBlockingStub<ConnectBlockingStub> {
    private ConnectBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectBlockingStub(channel, callOptions);
    }

    /**
     */
    public ru.vtb.blockchain.client.mkb.grpc.HelloReply sayHello(ru.vtb.blockchain.client.mkb.grpc.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ConnectFutureStub extends io.grpc.stub.AbstractFutureStub<ConnectFutureStub> {
    private ConnectFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.vtb.blockchain.client.mkb.grpc.HelloReply> sayHello(
        ru.vtb.blockchain.client.mkb.grpc.HelloRequest request) {
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
    private final ConnectImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConnectImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((ru.vtb.blockchain.client.mkb.grpc.HelloRequest) request,
              (io.grpc.stub.StreamObserver<ru.vtb.blockchain.client.mkb.grpc.HelloReply>) responseObserver);
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

  private static abstract class ConnectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConnectBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ru.vtb.blockchain.client.mkb.grpc.ConnectOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Connect");
    }
  }

  private static final class ConnectFileDescriptorSupplier
      extends ConnectBaseDescriptorSupplier {
    ConnectFileDescriptorSupplier() {}
  }

  private static final class ConnectMethodDescriptorSupplier
      extends ConnectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConnectMethodDescriptorSupplier(String methodName) {
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
      synchronized (ConnectGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConnectFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
