package com.lsz.strategy.api;

public class LinkedStrategy implements Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println(this.getClass().getCanonicalName());
    }
}
