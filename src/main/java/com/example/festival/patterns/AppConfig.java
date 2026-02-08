package com.example.festival.patterns;

public class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();

    private final String applicationName = "Festival API";

    private AppConfig() {
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public String getApplicationName() {
        return applicationName;
    }
}
