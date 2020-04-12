package ru.vtb.s7.client.mkb.grpc;

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
    comments = "Source: client.proto")
public final class ClientGrpc {

  private ClientGrpc() {}

  public static final String SERVICE_NAME = "Client";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ru.vtb.s7.client.mkb.grpc.ClientNewRequest,
      ru.vtb.s7.client.mkb.grpc.ClientNewReply> getCreateNewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNew",
      requestType = ru.vtb.s7.client.mkb.grpc.ClientNewRequest.class,
      responseType = ru.vtb.s7.client.mkb.grpc.ClientNewReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ru.vtb.s7.client.mkb.grpc.ClientNewRequest,
      ru.vtb.s7.client.mkb.grpc.ClientNewReply> getCreateNewMethod() {
    io.grpc.MethodDescriptor<ru.vtb.s7.client.mkb.grpc.ClientNewRequest, ru.vtb.s7.client.mkb.grpc.ClientNewReply> getCreateNewMethod;
    if ((getCreateNewMethod = ClientGrpc.getCreateNewMethod) == null) {
      synchronized (ClientGrpc.class) {
        if ((getCreateNewMethod = ClientGrpc.getCreateNewMethod) == null) {
          ClientGrpc.getCreateNewMethod = getCreateNewMethod =
              io.grpc.MethodDescriptor.<ru.vtb.s7.client.mkb.grpc.ClientNewRequest, ru.vtb.s7.client.mkb.grpc.ClientNewReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNew"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.vtb.s7.client.mkb.grpc.ClientNewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.vtb.s7.client.mkb.grpc.ClientNewReply.getDefaultInstance()))
              .setSchemaDescriptor(new ClientMethodDescriptorSupplier("CreateNew"))
              .build();
        }
      }
    }
    return getCreateNewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ru.vtb.s7.client.mkb.grpc.ClientNewRequest,
      ru.vtb.s7.client.mkb.grpc.ClientNewReply> getAddInnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddInn",
      requestType = ru.vtb.s7.client.mkb.grpc.ClientNewRequest.class,
      responseType = ru.vtb.s7.client.mkb.grpc.ClientNewReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ru.vtb.s7.client.mkb.grpc.ClientNewRequest,
      ru.vtb.s7.client.mkb.grpc.ClientNewReply> getAddInnMethod() {
    io.grpc.MethodDescriptor<ru.vtb.s7.client.mkb.grpc.ClientNewRequest, ru.vtb.s7.client.mkb.grpc.ClientNewReply> getAddInnMethod;
    if ((getAddInnMethod = ClientGrpc.getAddInnMethod) == null) {
      synchronized (ClientGrpc.class) {
        if ((getAddInnMethod = ClientGrpc.getAddInnMethod) == null) {
          ClientGrpc.getAddInnMethod = getAddInnMethod =
              io.grpc.MethodDescriptor.<ru.vtb.s7.client.mkb.grpc.ClientNewRequest, ru.vtb.s7.client.mkb.grpc.ClientNewReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddInn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.vtb.s7.client.mkb.grpc.ClientNewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.vtb.s7.client.mkb.grpc.ClientNewReply.getDefaultInstance()))
              .setSchemaDescriptor(new ClientMethodDescriptorSupplier("AddInn"))
              .build();
        }
      }
    }
    return getAddInnMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientStub>() {
        @java.lang.Override
        public ClientStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientStub(channel, callOptions);
        }
      };
    return ClientStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientBlockingStub>() {
        @java.lang.Override
        public ClientBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientBlockingStub(channel, callOptions);
        }
      };
    return ClientBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientFutureStub>() {
        @java.lang.Override
        public ClientFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientFutureStub(channel, callOptions);
        }
      };
    return ClientFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ClientImplBase implements io.grpc.BindableService {

    /**
     */
    public void createNew(ru.vtb.s7.client.mkb.grpc.ClientNewRequest request,
        io.grpc.stub.StreamObserver<ru.vtb.s7.client.mkb.grpc.ClientNewReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateNewMethod(), responseObserver);
    }

    /**
     */
    public void addInn(ru.vtb.s7.client.mkb.grpc.ClientNewRequest request,
        io.grpc.stub.StreamObserver<ru.vtb.s7.client.mkb.grpc.ClientNewReply> responseObserver) {
      asyncUnimplementedUnaryCall(getAddInnMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateNewMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ru.vtb.s7.client.mkb.grpc.ClientNewRequest,
                ru.vtb.s7.client.mkb.grpc.ClientNewReply>(
                  this, METHODID_CREATE_NEW)))
          .addMethod(
            getAddInnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ru.vtb.s7.client.mkb.grpc.ClientNewRequest,
                ru.vtb.s7.client.mkb.grpc.ClientNewReply>(
                  this, METHODID_ADD_INN)))
          .build();
    }
  }

  /**
   */
  public static final class ClientStub extends io.grpc.stub.AbstractAsyncStub<ClientStub> {
    private ClientStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientStub(channel, callOptions);
    }

    /**
     */
    public void createNew(ru.vtb.s7.client.mkb.grpc.ClientNewRequest request,
        io.grpc.stub.StreamObserver<ru.vtb.s7.client.mkb.grpc.ClientNewReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateNewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addInn(ru.vtb.s7.client.mkb.grpc.ClientNewRequest request,
        io.grpc.stub.StreamObserver<ru.vtb.s7.client.mkb.grpc.ClientNewReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddInnMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClientBlockingStub extends io.grpc.stub.AbstractBlockingStub<ClientBlockingStub> {
    private ClientBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientBlockingStub(channel, callOptions);
    }

    /**
     */
    public ru.vtb.s7.client.mkb.grpc.ClientNewReply createNew(ru.vtb.s7.client.mkb.grpc.ClientNewRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateNewMethod(), getCallOptions(), request);
    }

    /**
     */
    public ru.vtb.s7.client.mkb.grpc.ClientNewReply addInn(ru.vtb.s7.client.mkb.grpc.ClientNewRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddInnMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientFutureStub extends io.grpc.stub.AbstractFutureStub<ClientFutureStub> {
    private ClientFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.vtb.s7.client.mkb.grpc.ClientNewReply> createNew(
        ru.vtb.s7.client.mkb.grpc.ClientNewRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateNewMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.vtb.s7.client.mkb.grpc.ClientNewReply> addInn(
        ru.vtb.s7.client.mkb.grpc.ClientNewRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddInnMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_NEW = 0;
  private static final int METHODID_ADD_INN = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_NEW:
          serviceImpl.createNew((ru.vtb.s7.client.mkb.grpc.ClientNewRequest) request,
              (io.grpc.stub.StreamObserver<ru.vtb.s7.client.mkb.grpc.ClientNewReply>) responseObserver);
          break;
        case METHODID_ADD_INN:
          serviceImpl.addInn((ru.vtb.s7.client.mkb.grpc.ClientNewRequest) request,
              (io.grpc.stub.StreamObserver<ru.vtb.s7.client.mkb.grpc.ClientNewReply>) responseObserver);
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

  private static abstract class ClientBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ru.vtb.s7.client.mkb.grpc.ClientOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Client");
    }
  }

  private static final class ClientFileDescriptorSupplier
      extends ClientBaseDescriptorSupplier {
    ClientFileDescriptorSupplier() {}
  }

  private static final class ClientMethodDescriptorSupplier
      extends ClientBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClientGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientFileDescriptorSupplier())
              .addMethod(getCreateNewMethod())
              .addMethod(getAddInnMethod())
              .build();
        }
      }
    }
    return result;
  }
}
