package ru.vtb.s7.client.mkb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class Encryption {
    private static final String password = "123abc";

    private static final String pathKeyStore = "keystore.ks";

    KeyStore keyStore;

    Encryption() throws KeyStoreException {
        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

        char[] keyStorePassword = password.toCharArray();
        try {
//            InputStream keyStoreData = new FileInputStream("keystore.ks");

            keyStore.load(null, keyStorePassword);
        } catch (NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }

        save();
    }

    private void save() {
        char[] keyStorePassword = password.toCharArray();
        try (FileOutputStream keyStoreOutputStream = new FileOutputStream("data/keystore.ks")) {
            keyStore.store(keyStoreOutputStream, keyStorePassword);
        } catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }
    }

}
