package com.epam.blokhina.nProperties;


import com.epam.blokhina.nProperties.impl.First;
import com.epam.blokhina.nProperties.impl.Second;
import org.apache.log4j.Logger;

public class NPropsFactory {
    final static Logger logger = Logger.getLogger(NPropsFactory.class);

    public static AbstractEntityReader getProperties(String prop, String fileName) {
        switch (prop) {
            case "first":
                return new First(fileName);
            case "second":
                return new Second(fileName);
            default:
                logger.warn("Incorrect property. As default set First");
                return new First(fileName);
        }
    }
}
