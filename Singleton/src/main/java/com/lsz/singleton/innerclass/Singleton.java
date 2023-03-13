package com.lsz.singleton.innerclass;

public class Singleton {

    private Singleton(){};

    public static Singleton getInstance() {
        return SingletonFactory.singleton;
    }

    static class SingletonFactory {
        private static final Singleton singleton = new Singleton();
    }

}
