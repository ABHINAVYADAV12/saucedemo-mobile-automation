package com.saucedemo.utils;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "config.properties was not found in src/test/resources"
                );
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load configuration from config.properties",
                    e
            );
        }
    }

    private ConfigReader() {
        // Utility class
    }

    public static String get(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new RuntimeException(
                    "Missing or empty configuration property: " + key
            );
        }

        return value.trim();
    }
}