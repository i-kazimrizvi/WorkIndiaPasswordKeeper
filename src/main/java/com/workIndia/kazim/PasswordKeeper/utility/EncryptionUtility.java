package com.workIndia.kazim.PasswordKeeper.utility;

public class EncryptionUtility {


    private final String key = "sdmlkasldjlaksdml!@&&%#dlskdl";


    public static String encryptPassword(String password) {
        return EncryptionMain.encrypt(password);
    }

    public static String decrypt(String password) {
        return EncryptionMain.decrypt(password);
    }
}
