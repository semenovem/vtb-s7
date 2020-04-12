package ru.vtb.s7.client.mkb.testServer;

import java.io.File;

/**
 * Обеспечивает приложение сертификатами
 * Здесь возможна логика для разных environments
 */
public class Credential implements ICredential {
    private final String certChainFilePath = "./server.pem";
    private final String privateKeyFilePath = "./server.key";
    private final String trustCertCollectionFilePath = "./ca.pem";

    @Override
    public File getCertChain() {
        return new File(certChainFilePath);
    }

    @Override
    public File getPrivateKey() {
        return new File(privateKeyFilePath);
    }

    @Override
    public File getTrustCertCollection() {
        return new File(trustCertCollectionFilePath);
    }
}
