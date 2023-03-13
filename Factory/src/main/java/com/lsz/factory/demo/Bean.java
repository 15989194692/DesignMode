package com.lsz.factory.demo;

public class Bean {

    private Ref ref;

    public Bean(Ref ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "ref=" + ref +
                '}';
    }
}
