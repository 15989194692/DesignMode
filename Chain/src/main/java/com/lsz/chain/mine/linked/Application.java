package com.lsz.chain.mine.linked;

public class Application {
    public static void main(String[] args) {
        final FilterChain filterChain = new FilterChain();
        filterChain.addHandler(new LogHandler());
        filterChain.addHandler(new PrintHandler());

        filterChain.handle();
    }
}
