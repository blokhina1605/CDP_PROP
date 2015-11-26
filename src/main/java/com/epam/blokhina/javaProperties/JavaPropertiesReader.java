package com.epam.blokhina.javaProperties;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class JavaPropertiesReader {
    private static final JavaPropertiesReader READER = new JavaPropertiesReader();
    private static String PATH;
    private static Properties properties = new Properties();
    final static Logger logger = Logger.getLogger(JavaPropertiesReader.class);

    private JavaPropertiesReader() {
    }

    public static JavaPropertiesReader getInstance(String path) {
        load(path);
        return READER;
    }

    private static void load(String path) {
        try (InputStream inputStream = Files.newInputStream(Paths.get(".").resolve(path))) {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Something was wrong when reading " + path);
        }
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    public List<String> getListFromProperty(String propertyName) {
        return Arrays.asList(properties.getProperty(propertyName).split(","));
    }
}
