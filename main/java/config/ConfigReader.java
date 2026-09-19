package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IllegalStateException("config.properties was not found on the test classpath");
            }
            PROPERTIES.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load config.properties", e);
        }
    }

    private ConfigReader() {}

    public static String get(String key) {
        String envKey = key.toUpperCase().replace('.', '_');
        String envValue = System.getenv(envKey);
        if (envValue == null && key.equals("api.token")) envValue = System.getenv("ORANGEHRM_API_TOKEN");
        if (envValue != null && !envValue.isBlank()) return envValue;
        String value = PROPERTIES.getProperty(key);
        if (value == null) throw new IllegalArgumentException("Missing configuration key: " + key);
        return value.trim();
    }

    public static int getInt(String key) { return Integer.parseInt(get(key)); }
    public static boolean getBoolean(String key) { return Boolean.parseBoolean(get(key)); }
}
