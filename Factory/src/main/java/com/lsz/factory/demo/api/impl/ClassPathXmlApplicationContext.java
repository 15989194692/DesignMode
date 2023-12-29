package com.lsz.factory.demo.api.impl;

import com.lsz.factory.demo.api.ApplicationContext;
import com.lsz.factory.demo.api.BeanConfig;
import com.lsz.factory.demo.api.ConfigParser;
import com.lsz.factory.demo.exception.BeansException;
import com.lsz.factory.demo.factory.BeansFactory;
import com.lsz.factory.demo.factory.SimpleBeansFactory;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private static final Logger LOGGER = Logger.getLogger(ClassPathXmlApplicationContext.class.getName());

    private BeansFactory simpleBeansFactory;
    private ConfigParser configParser;

    public ClassPathXmlApplicationContext(String xmlClassPath) {
        simpleBeansFactory = new SimpleBeansFactory();
        configParser = new Dom4jXmlConfigParser();
        loadBeanConfig(xmlClassPath);
    }


    private void loadBeanConfig(String xmlClassPath) {
        try (InputStream inputStream = this.getClass().getResourceAsStream("/" + xmlClassPath)) {
            if (inputStream == null) {
                LOGGER.log(Level.SEVERE, "can not find file {" + xmlClassPath + "}");
                throw new RuntimeException("can not find file {" + xmlClassPath + "}");
            }
            final List<BeanConfig> beanConfigs = configParser.parse(inputStream);
            for (BeanConfig beanConfig : beanConfigs) {
                simpleBeansFactory.registerBeanConfig(beanConfig);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "can not open file {" + xmlClassPath + "}", e);
            throw new RuntimeException("can not open file {" + xmlClassPath + "}", e);
        }

    }

    @Override
    public Object getBean(String beanId) throws BeansException {
        return simpleBeansFactory.getBean(beanId);
    }

}
