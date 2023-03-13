package com.lsz.observer.demo;

import com.lsz.observer.api.Observer;

public class LogObserver implements Observer {
    @Override
    public void update() {
        System.out.println(LogObserver.class.getName());
    }
}
