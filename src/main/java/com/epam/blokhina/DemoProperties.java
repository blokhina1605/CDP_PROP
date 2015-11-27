package com.epam.blokhina;

import com.epam.blokhina.apacheProperties.ApachePropertiesReader;
import com.epam.blokhina.groovyProperties.GroovyPropertiesReader;
import com.epam.blokhina.javaProperties.JavaPropertiesReader;
import com.epam.blokhina.nProperties.AbstractEntityReader;
import com.epam.blokhina.nProperties.NPropsFactory;
import com.epam.blokhina.yandexProperties.PropsFactory;
import com.epam.blokhina.yandexProperties.YandexInterfaceProp;
import org.apache.log4j.Logger;


public class DemoProperties {
    final static Logger logger = Logger.getLogger(DemoProperties.class);


    public static void main(String[] args) {
        //demo java reader properties
        long before = System.currentTimeMillis();
        demoJavaProperties();
        long after = System.currentTimeMillis();
        logger.info("Current operation takes " + (after - before) + " mls");

        //demo apache reader properties
        before = System.currentTimeMillis();
        demoApacheProperties();
        after = System.currentTimeMillis();
        logger.info("Current operation takes " + (after - before) + " mls");

        //demo groovy reader properties
        before = System.currentTimeMillis();
        demoGroovyProperties();
        after = System.currentTimeMillis();
        logger.info("Current operation takes " + (after - before) + " mls");

        //demo yandex reader properties
        before = System.currentTimeMillis();
        demoYandexProperties();
        after = System.currentTimeMillis();
        logger.info("Current operation takes " + (after - before) + " mls");

        //demo yandex reader properties
        before = System.currentTimeMillis();
        demoNProperty();
        after = System.currentTimeMillis();
        logger.info("Current operation takes " + (after - before) + " mls");
    }

    private static void demoJavaProperties() {
        JavaPropertiesReader javaPropertiesReader = JavaPropertiesReader.getInstance(Paths.PROPERTIES_PATH);
        logger.info(javaPropertiesReader.getProperty("first.user.login"));
        logger.info(javaPropertiesReader.getProperty("first.user.psw"));
        logger.info(javaPropertiesReader.getListFromProperty("first.categories"));
    }

    private static void demoApacheProperties() {
        ApachePropertiesReader apachePropertiesReader = ApachePropertiesReader.getInstance(Paths.PROPERTIES_PATH);
        logger.info(apachePropertiesReader.getProperty("first.user.login"));
        logger.info(apachePropertiesReader.getProperty("first.user.psw"));
        logger.info(apachePropertiesReader.getListFromProperty("first.categories"));
    }

    private static void demoGroovyProperties() {
        GroovyPropertiesReader groovyPropertiesReader = GroovyPropertiesReader.getInstance(Paths.GROOVY_PROPERTIES_PATH);
        logger.info(groovyPropertiesReader.getProperty("first.user.login"));
        logger.info(groovyPropertiesReader.getProperty("first.user.psw"));
        logger.info(groovyPropertiesReader.getProperty("first.categories"));
    }

    private static void demoYandexProperties() {
        YandexInterfaceProp first = PropsFactory.getProperties("first");
        logger.info(first.getLogin());
        logger.info(first.getPassword());
        logger.info(first.getCategories());
    }

    private static void demoNProperty() {
        AbstractEntityReader first = NPropsFactory.getProperties("first", Paths.PROPERTIES_PATH);
        logger.info(first.getLogin());
        logger.info(first.getPsw());
        logger.info(first.getCategories());
    }
}
