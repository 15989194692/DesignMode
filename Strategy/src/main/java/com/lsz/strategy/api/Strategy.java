package com.lsz.strategy.api;

public interface Strategy {

    void algorithmInterface();

    public static enum Type {
        ARRAY,
        LINKED
    }
}
