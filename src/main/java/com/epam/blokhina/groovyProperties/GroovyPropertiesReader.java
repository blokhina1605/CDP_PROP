package com.epam.blokhina.groovyProperties;


import com.epam.blokhina.apacheProperties.ApachePropertiesReader;
import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;
import org.apache.log4j.Logger;

import java.io.File;
import java.net.MalformedURLException;

public class GroovyPropertiesReader {
    private static ConfigObject config;
    private static final GroovyPropertiesReader READER = new GroovyPropertiesReader();
    final static Logger logger = Logger.getLogger(ApachePropertiesReader.class);

    private GroovyPropertiesReader() {
    }

    public static GroovyPropertiesReader getInstance(String filePath) {
        try {
            config = new ConfigSlurper().parse(new File(filePath).toURI().toURL());
        } catch (MalformedURLException e) {
            logger.error("Something was wrong when reading " + filePath);
        }
        return READER;
    }

    public String getProperty(String key) {
        return config.toProperties().getProperty(key);
    }
}
