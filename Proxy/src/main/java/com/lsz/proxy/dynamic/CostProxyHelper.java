package com.lsz.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class CostProxyHelper {

    public static Object createProxy(Object proxyObject) {
        final Class<?> proxyObjectClass = proxyObject.getClass();
        Class[] proxyObjectInterfaces = proxyObjectClass.getInterfaces();
        final Object proxy = Proxy.newProxyInstance(proxyObjectClass.getClassLoader(), proxyObjectInterfaces, new CostProxyHandler(proxyObject));
        return proxy;
    }



}
