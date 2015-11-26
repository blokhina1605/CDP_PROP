package com.epam.blokhina.yandexProperties;


import com.epam.blokhina.apacheProperties.ApachePropertiesReader;
import com.epam.blokhina.yandexProperties.impl.First;
import com.epam.blokhina.yandexProperties.impl.Second;
import org.apache.log4j.Logger;

public class PropsFactory {
    final static Logger logger = Logger.getLogger(PropsFactory.class);

    public static YandexInterfaceProp getProperties(String prop) {
        switch (prop) {
            case "first":
                return new First();
            case "second":
                return new Second();
            default:
                logger.warn("Incorrect property. As default set First");
                return new First();
        }
    }
}
