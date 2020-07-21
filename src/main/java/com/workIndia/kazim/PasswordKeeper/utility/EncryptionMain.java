package com.workIndia.kazim.PasswordKeeper.utility;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionMain {

    private static final String AES_ENCRYPTION_KEY = "uHgYu7P0ptwtuaho";
    private static final String INT_VEC = "sdsopiuioyyttyhj";

    public static String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(INT_VEC.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(AES_ENCRYPTION_KEY.getBytes("UTF-8"), "AES");

            Cipher cipherInstance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipherInstance.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipherInstance.doFinal(value.getBytes());
            return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static String decrypt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(INT_VEC.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(AES_ENCRYPTION_KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
