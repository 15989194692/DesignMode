package com.lsz.chain.array;

public class Application {

    public static void main(String[] args) {
        final IFilterChain iFilterChain = new IFilterChain();
        iFilterChain.addHandler(new IPrintHandler());
        iFilterChain.addHandler(new ILogHandler());

        iFilterChain.handle();
    }
}
