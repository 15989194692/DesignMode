package com.lsz.strategy.api;

public class ArrayStrategy implements Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println(this.getClass().getCanonicalName());
    }
}
