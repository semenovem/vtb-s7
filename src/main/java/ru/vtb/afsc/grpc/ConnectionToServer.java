package ru.vtb.afsc.grpc;

import java.io.File;
import io.grpc.ManagedChannel;
import io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.NettyChannelBuilder;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Задача класса - установить соединение с сервером rpc с tls
 */
public class ConnectionToServer {

    private static final Logger LOG = LoggerFactory.getLogger(Client.class);

    /**
     * Хост получить из переменных окружения
     */
    private final String host = "localhost";

    /**
     * Порт получить из переменных окружения
     */
    private final int port = 50051;

    /**
     * Сертификаты получить из trustStore & keyStore
     */
    private final String certChainFilePath = "/Users/evg/_dev/work/vtb/s7/assets/cert/client.pem";
    private final String privateKeyFilePath = "/Users/evg/_dev/work/vtb/s7/assets/cert/client.key";
    private final String trustCertCollectionFilePath = "/Users/evg/_dev/work/vtb/s7/assets/cert/ca.pem";

    private ManagedChannel channel;

    public ConnectionToServer() throws SSLException {
        channel = NettyChannelBuilder
            .forAddress(host, port)
            .sslContext(buildSslContext())
            .build();
    }

    private SslContext buildSslContext() throws SSLException {
        SslContextBuilder builder = GrpcSslContexts.forClient();

        builder.trustManager(new File(trustCertCollectionFilePath));
        builder.keyManager(new File(certChainFilePath), new File(privateKeyFilePath));

        return builder.build();
    }

    public void close() {
        try {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOG.error("Failed to shutdown of channel", e);
        }
    }

    public ManagedChannel getChannel() {
        return channel;
    }

    public String toString() {
        return "host=" + host + ", port=" + port;
    }
}
