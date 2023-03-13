package com.lsz.util;

public class Holder<T> {
    private T t;

    public Holder() {
    }

    public T get() {
        return this.t;
    }

    public void set(T t) {
        this.t = t;
    }

}
