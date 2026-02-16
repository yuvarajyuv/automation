package com.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ConfigReader loads values from config.properties file.
 *
 * File location: src/test/resources/config.properties
 *
 * You will maintain environment-specific values there (URL, username, password, etc.).
 * In your tests or pages, you call the static getter methods here to fetch the values.
 */
public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream =
                     ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException("config.properties file not found in classpath");
            }

            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getUsername() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    /**
     * Generic method if you want to fetch any other key from config.properties.
     */
    public static String get(String key) {
        return properties.getProperty(key);
    }
}

