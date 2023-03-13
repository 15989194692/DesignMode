package com.lsz.observer.demo;

public class Application {

    public static void main(String[] args) {
        final MySubject mySubject = new MySubject();
        mySubject.registerObserver(new LogObserver());
        mySubject.registerObserver(new SysObserver());
        mySubject.notifyObservers();
    }
}
