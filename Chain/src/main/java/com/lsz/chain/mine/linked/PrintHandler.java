package com.lsz.chain.mine.linked;

public class PrintHandler extends Handler {

    public boolean doHandle() {
        System.out.println(this.getClass().getName());
        return true;
    }
}
