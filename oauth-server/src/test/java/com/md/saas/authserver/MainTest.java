package com.md.saas.authserver;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

/**
 * @Classname MainTest
 * @Description TODO
 * @Date 2020/06/28 14:30
 * @Created by hjchen
 */
public class MainTest {

    @Test
    void test() {
        System.out.println("Hello World!");
    }

    @Test
    void testBase64() {
        String authorization_user = Base64.getEncoder().encodeToString("user-client:user-secret-8888".getBytes());
        String authorization_code = Base64.getEncoder().encodeToString("order-client:order-secret-8888".getBytes());
        System.out.println(authorization_user);
        System.out.println(authorization_code);
        System.out.println(new BCryptPasswordEncoder().encode("user-secret-8888"));
        System.out.println(new BCryptPasswordEncoder().encode("order-secret-8888"));
    }
}
