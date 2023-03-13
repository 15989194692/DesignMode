package com.lsz.factory.demo.api;

import java.rmi.NoSuchObjectException;

public interface ApplicationContext {

    Object getBean(String beanId) throws NoSuchObjectException;
}
