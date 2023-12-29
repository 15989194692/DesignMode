package com.lsz.factory.demo.api;

import com.lsz.factory.demo.exception.BeansException;

public interface ApplicationContext {

    Object getBean(String beanId) throws BeansException;
}
