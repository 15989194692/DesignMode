package com.lsz.factory.demo;

public class Ref {

    private String name;

    public Ref(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ref{" +
                "name='" + name + '\'' +
                '}';
    }
}
