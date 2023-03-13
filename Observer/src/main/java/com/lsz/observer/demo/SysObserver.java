package com.lsz.observer.demo;

import com.lsz.observer.api.Observer;

public class SysObserver implements Observer {
    @Override
    public void update() {
        System.out.println(SysObserver.class.getName());
    }
}
