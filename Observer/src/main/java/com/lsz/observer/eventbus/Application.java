package com.lsz.observer.eventbus;

public class Application {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new Observers());
        eventBus.post(new AMsg());
        System.out.println("----------------------");
        eventBus.post(new ParentMsg());
        System.out.println("----------------------");
        eventBus.post(new ChildMsg());
    }
}
