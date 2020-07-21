package com.workIndia.kazim.PasswordKeeper.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashUtility {

    public static BCryptPasswordEncoder getPasswordHasher(){
        return new BCryptPasswordEncoder();
    }
}
