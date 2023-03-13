package com.lsz.observer.eventbus;

public class Observers {

    @Subscribe
    public void a(AMsg aMsg) {
        System.out.println("Accept AMsg");
    }

    @Subscribe
    public void parent(ParentMsg parentMsg) {
        System.out.println("Accept ParentMsg | ChildMsg");
    }

    @Subscribe
    public void child(ChildMsg childMsg) {
        System.out.println("Accept ChildMsg");
    }

//    @Subscribe
    public void illegal(AMsg aMsg, ChildMsg childMsg) {
        System.out.println("Illegal");
    }
}
