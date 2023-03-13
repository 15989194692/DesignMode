package com.lsz.observer.eventbus;

import java.util.Set;

public class EventBus {
    private ObserverRegistry observerRegistry;

    public EventBus() {
        observerRegistry = new ObserverRegistry();
    }

    public void register(Object observer) {
        observerRegistry.register(observer);
    }

    public void post(Object event) {
        Set<ObserverAction> notifySets = observerRegistry.getNotifySets(event);
        for (ObserverAction observerAction : notifySets) {
            observerAction.invoke(event);
        }
    }
}
