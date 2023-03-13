package com.lsz.chain.array;

public class IPrintHandler implements IHandler {
    public boolean handle() {
        System.out.println(this.getClass().getName());
        return true;
    }
}
