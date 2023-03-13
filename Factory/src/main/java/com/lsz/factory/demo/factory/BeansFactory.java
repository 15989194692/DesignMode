package com.lsz.factory.demo.factory;

import com.lsz.factory.demo.api.BeanConfig;
import com.lsz.factory.demo.api.ConstructorArg;

import java.lang.reflect.InvocationTargetException;
import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class BeansFactory {

    private static final Logger LOGGER = Logger.getLogger(BeansFactory.class.getName());

    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private Map<String, BeanConfig> beanConfigs = new ConcurrentHashMap<>();



    public Object getBean(String beanId) throws NoSuchObjectException {
        BeanConfig beanConfig = beanConfigs.get(beanId);
        if (beanConfig == null) {
            throw new NoSuchObjectException("bean: " + beanId + " is not defined");
        }
        return createBean(beanConfig);
    }


    public void addBeanConfigs(List<BeanConfig> beanConfigList) {
        for (BeanConfig beanConfig : beanConfigList) {
            beanConfigs.putIfAbsent(beanConfig.getId(), beanConfig);
        }

        for (BeanConfig beanConfig : beanConfigList) {
            if (!beanConfig.isLazyInit() && beanConfig.isSingleton()) {
                createBean(beanConfig);
            }
        }
    }

    private Object createBean(BeanConfig beanConfig) {
        Object bean = null;
        if (beanConfig.isSingleton() && (bean = singletonObjects.get(beanConfig.getId())) != null) {
            return bean;
        }
        try {
            Class beanClass = Class.forName(beanConfig.getClassName());
            List<ConstructorArg> constructorArgs = beanConfig.getConstructorArgs();
            if (constructorArgs.isEmpty()) {
                bean = beanClass.newInstance();
            } else {
                Class[] argsClasses = new Class[constructorArgs.size()];
                Object[] argsObjects = new Object[constructorArgs.size()];
                for (int i = 0; i < constructorArgs.size(); ++i) {
                    ConstructorArg constructorArg = constructorArgs.get(i);
                    if (!constructorArg.isRef()) {
                        argsClasses[i] = constructorArg.getType();
                        argsObjects[i] = constructorArg.getArg();
                    } else {
                        BeanConfig refBeanConfig = beanConfigs.get(constructorArg.getArg());
                        if (refBeanConfig == null) {
                            throw new RuntimeException("Reference bean: " + constructorArg.getArg() + " not defied");
                        }
                        argsClasses[i] =  Class.forName(refBeanConfig.getClassName());
                        argsObjects[i] = createBean(refBeanConfig);
                    }
                }

                bean = beanClass.getConstructor(argsClasses).newInstance(argsObjects);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
//            throw new BeanCreationFailureException("", e);
        }
        if (bean != null && beanConfig.isSingleton()) {
            singletonObjects.putIfAbsent(beanConfig.getId(), bean);
            return singletonObjects.get(beanConfig.getId());
        }
        return bean;
    }

}
