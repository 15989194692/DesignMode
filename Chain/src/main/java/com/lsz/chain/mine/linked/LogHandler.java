package com.lsz.chain.mine.linked;

public class LogHandler extends Handler {

    public boolean doHandle() {
        System.out.println(this.getClass().getName());
        return true;
    }
}
