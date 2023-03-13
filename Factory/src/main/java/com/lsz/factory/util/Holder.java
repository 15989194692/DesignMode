package com.lsz.factory.util;

public class Holder<V> {

    private V v;

    public Holder(V v) {
        this.v = v;
    }

    public Holder() {}


    public V get() {
        return v;
    }

    public void set(V v) {
        this.v = v;
    }


}
