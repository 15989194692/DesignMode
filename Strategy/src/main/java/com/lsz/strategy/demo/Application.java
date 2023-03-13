package com.lsz.strategy.demo;

import com.lsz.strategy.api.Strategy;
import com.lsz.strategy.api.SingleStrategyFactory;

public class Application {

    private static final String STRATEGY_TYPE_KEY = "strategy.type";
    public static void main(String[] args) {
        String type = System.getProperty(STRATEGY_TYPE_KEY);
        final Strategy strategy = SingleStrategyFactory.getStrategy(type);
        strategy.algorithmInterface();
    }
}
