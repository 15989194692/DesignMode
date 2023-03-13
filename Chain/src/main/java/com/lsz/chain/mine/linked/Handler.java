package com.lsz.chain.mine.linked;

public abstract class Handler {

    protected Handler successor = null;


    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void handle() {
        boolean success = doHandle();
        if (success && successor != null) {
            successor.handle();
        }
    }

    public abstract boolean doHandle();

}
