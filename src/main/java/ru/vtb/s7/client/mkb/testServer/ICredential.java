package ru.vtb.s7.client.mkb.testServer;

import java.io.File;

public interface ICredential {
    /**
     * Сертификат сервера
     */
    File getCertChain();

    /**
     * Приватный ключ сервера
     */
    File getPrivateKey();

    /**
     * Корневой сертификат
     */
    File getTrustCertCollection();
}
