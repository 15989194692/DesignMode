package com.lsz.chain.array;

public class ILogHandler implements IHandler {
    public boolean handle() {
        System.out.println(this.getClass().getName());
        return true;
    }
}
