package com.epam.blokhina.nProperties;

import jfork.nproperty.ConfigParser;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class AbstractEntityReader {

    final static Logger logger = Logger.getLogger(AbstractEntityReader.class);

    public abstract String getLogin();

    public abstract String getPsw();

    public abstract List<String> getCategories();

    public AbstractEntityReader(String filename) {
        read(filename);
    }

    protected void read(String filename) {
        try {
            ConfigParser.parse(this, filename);
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException | IOException e) {
            logger.error("Something was wrong when parsing " + filename);
        }
    }
}
