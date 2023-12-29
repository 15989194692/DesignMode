package com.lsz.factory.demo.factory;

import com.lsz.factory.demo.api.BeanConfig;
import com.lsz.factory.demo.exception.BeansException;

/**
 * @ClassName BeansFactory
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/12/29 下午5:49
 * @Version 1.0.0
 **/
public interface BeansFactory {


    Object getBean(String beanId) throws BeansException;

    void registerBeanConfig(BeanConfig beanConfig);


}
