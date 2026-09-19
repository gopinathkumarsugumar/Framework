package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties= new Properties();

    static {
        try {
            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties NOT FOUND");
            }

            properties.load(input);
        }catch (IOException e) {
            throw new RuntimeException("config.properties not found/ failed to load");
        }
    }
    public  static  String getProperty(String key){
        return  properties.getProperty(key);
    }
        }


