package com.skyforce;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Sulaymon on 18.03.2018.
 */
public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("1234s");
        System.out.println(encode);
    }
}
