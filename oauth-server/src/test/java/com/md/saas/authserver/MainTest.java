package com.md.saas.authserver;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

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
        String authorization_admin = Base64.getEncoder().encodeToString("admin-app:123456".getBytes());
        System.out.println(authorization_user);
        System.out.println(authorization_code);
        System.out.println(authorization_admin);
        System.out.println(new BCryptPasswordEncoder().encode("user-secret-8888"));
        System.out.println(new BCryptPasswordEncoder().encode("order-secret-8888"));
    }

    @Test
    public void testLocalDate() {
        long expire = 1618738536l;
        LocalDateTime time2 =LocalDateTime.ofEpochSecond(expire,0,ZoneOffset.ofHours(8));
        LocalDateTime now = LocalDateTime.now();
        Long timestamp = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        LocalDateTime after = now.plus(3600, ChronoUnit.SECONDS);
        System.out.println(time2.isAfter(now));
        System.out.println(now.toEpochSecond(ZoneOffset.of("+8")));
        System.out.println(timestamp);

        System.out.println("now = " + now + ",after = " + after);
        System.out.println(time2);
    }

}
