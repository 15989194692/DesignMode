package com.lsz.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CostProxyHandler implements InvocationHandler {

    private Object proxyObject;

    public CostProxyHandler(Object proxyObject) {
        this.proxyObject = proxyObject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final long start = System.currentTimeMillis();
        final Object res = method.invoke(proxyObject, args);
        final long end = System.currentTimeMillis();
        System.out.println(this.getClass().getName() + " method cost = " + (end - start));
        return res;
    }
}
