package com.lsz.factory.demo.api.impl;

import com.lsz.factory.demo.api.ApplicationContext;
import com.lsz.factory.demo.api.BeanConfig;
import com.lsz.factory.demo.api.ConfigParser;
import com.lsz.factory.demo.factory.BeansFactory;
import com.lsz.factory.demo.factory.ConfigParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private static final Logger LOGGER = Logger.getLogger(ClassPathXmlApplicationContext.class.getName());

    private BeansFactory beansFactory;
    private ConfigParser configParser;

    public ClassPathXmlApplicationContext(String xmlClassPath) {
        beansFactory = new BeansFactory();
        configParser = new XmlConfigParser();
        loadBeanConfig(xmlClassPath);
    }


    private void loadBeanConfig(String xmlClassPath) {
        try (InputStream inputStream = this.getClass().getResourceAsStream("/" + xmlClassPath)) {
            if (inputStream == null) {
                LOGGER.log(Level.SEVERE, "can not find file {" + xmlClassPath + "}");
                throw new RuntimeException("can not find file {" + xmlClassPath + "}");
            }
            final List<BeanConfig> beanConfigs = configParser.parse(inputStream);
            beansFactory.addBeanConfigs(beanConfigs);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "can not open file {" + xmlClassPath + "}", e);
            throw new RuntimeException("can not open file {" + xmlClassPath + "}", e);
        }

    }

    @Override
    public Object getBean(String beanId) throws NoSuchObjectException {
        return beansFactory.getBean(beanId);
    }



}
