package com.lsz.factory.demo;

import com.lsz.factory.demo.api.impl.ClassPathXmlApplicationContext;

import java.rmi.NoSuchObjectException;

public class Application {

    public static void main(String[] args) throws NoSuchObjectException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanConfig.xml");
        Bean bean = (Bean) applicationContext.getBean("bean");
        System.out.println("bean = " + bean);
        Ref ref = (Ref) applicationContext.getBean("ref");
        System.out.println("ref = " + ref);
    }
}
