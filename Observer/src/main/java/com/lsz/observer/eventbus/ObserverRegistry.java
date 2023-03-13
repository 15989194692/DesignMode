package com.lsz.observer.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ObserverRegistry {

    private ConcurrentHashMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registryMap;

    public ObserverRegistry() {
        registryMap = new ConcurrentHashMap<>();
    }

    public void register(Object observer) {
        List<Method> subscribeMethods = getSubscribeMethod(observer.getClass());
        for (Method method : subscribeMethods) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            ObserverAction observerAction = new ObserverAction(observer, method);
            Class<?> acceptEventClass = parameterTypes[0];
            registerObserver(acceptEventClass, observerAction);
        }
    }

    private List<Method> getSubscribeMethod(Class<?> observerClass) {
        List<Method> subscribeMethods = new ArrayList<>();

        Method[] declaredMethods = observerClass.getDeclaredMethods();

        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                int parameterTypesLength = method.getParameterTypes().length;
                if (parameterTypesLength != 1) {
                    throw new IllegalArgumentException(String.format("Method %s has @Subscribe annotation but has %s parameters. Subscriber methods must have exactly 1 parameter.", method, parameterTypesLength));
                }
                subscribeMethods.add(method);
            }
        }
        return subscribeMethods;
    }

    public Set<ObserverAction> getNotifySets(Object event) {
        CopyOnWriteArraySet<ObserverAction> observerActions = registryMap.get(event.getClass());
        return observerActions == null ? Collections.emptySet() : observerActions;
    }

    private void registerObserver(Class<?> acceptEventClass, ObserverAction observerAction) {
        if (acceptEventClass == null || acceptEventClass.equals(Object.class)) {
            return;
        }
        CopyOnWriteArraySet<ObserverAction> observerActions = registryMap.get(acceptEventClass);
        if (observerActions == null) {
            registryMap.putIfAbsent(acceptEventClass, new CopyOnWriteArraySet<>());
            observerActions = registryMap.get(acceptEventClass);
        }
        observerActions.add(observerAction);
//        registerObserver(acceptEventClass.getSuperclass(), observerAction);
    }

    private boolean isSubscribeMethod(Method method) {
        return method.getAnnotation(Subscribe.class) != null;
    }

}
