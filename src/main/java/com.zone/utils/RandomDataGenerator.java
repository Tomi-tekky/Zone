package com.zone.utils;

import java.util.Random;
import java.util.UUID;

public class RandomDataGenerator {
    // Generate a random string with a prefix
    public static String getRandomString(String prefix, int bound) {
        return prefix + new Random().nextInt(bound);
    }

    // Generate a random email address
    public static String getRandomEmail(String domain) {
        return "user" + new Random().nextInt(1000) + "@" + domain;
    }

    // Generate a random phone number
    public static String getRandomPhoneNumber() {
        Random random = new Random();
        return "11" + (random.nextInt(900000000) + 100000000); // 10-digit number
    }

    // Generate a random UUID
    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }
}