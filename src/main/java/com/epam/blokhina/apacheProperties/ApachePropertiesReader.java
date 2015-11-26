package com.epam.blokhina.apacheProperties;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;


public class ApachePropertiesReader {
    private static final ApachePropertiesReader READER = new ApachePropertiesReader();
    private static Configuration configuration;
    final static Logger logger = Logger.getLogger(ApachePropertiesReader.class);

    private ApachePropertiesReader() {
    }

    public static ApachePropertiesReader getInstance(String filePath) {
        try {
            configuration = new PropertiesConfiguration(filePath);
        } catch (ConfigurationException e) {
            logger.error("Something was wrong when reading " + filePath);
        }
        return READER;
    }

    public String getProperty(String key) {
        return configuration.getString(key);
    }

    public List<String> getListFromProperty(String key) {
        return Arrays.asList(configuration.getStringArray(key));
    }
}
