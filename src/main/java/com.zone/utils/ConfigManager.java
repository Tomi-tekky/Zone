package com.zone.utils;

import java.util.Properties;

public class ConfigManager {
    private Properties properties;
    public ConfigManager(String filePath) {
        this.properties = ConfigReader.loadProperties(filePath);
    }

    // Replace placeholders dynamically
    public String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value != null && value.contains("${")) {
            value = resolvePlaceholders(value);
        }
        return value;
    }

    private String resolvePlaceholders(String value) {
        // Example: Replace ${environment} with the current environment
        String environment = System.getProperty("environment", "dev");
        return value.replace("${environment}", environment);
    }
}
