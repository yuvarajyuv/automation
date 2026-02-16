package com.automation.utils;

import java.util.UUID;

/**
 * Utility methods for generating random / unique test data.
 *
 * Example usages in your tests:
 *  - TestDataUtils.generateRandomEmail()
 *  - TestDataUtils.generateRandomString(10)
 */
public class TestDataUtils {

    /**
     * Generates a random email address.
     * Use this when you need a unique email for registration or similar fields.
     */
    public static String generateRandomEmail() {
        return "user_" + System.currentTimeMillis() + "@example.com";
    }

    /**
     * Generates a random alpha-numeric string of given length.
     * Can be used for random reference IDs, names, etc.
     */
    public static String generateRandomString(int length) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        if (length <= 0 || length >= uuid.length()) {
            return uuid;
        }
        return uuid.substring(0, length);
    }
}

