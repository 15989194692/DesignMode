package com.lsz.strategy.api;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * for Single（单例）
 */
public class SingleStrategyFactory {

    private static final Map<String, Strategy> STRING_STRATEGY_MAP = new HashMap<>();
    static {
        STRING_STRATEGY_MAP.put(Strategy.Type.ARRAY.name(), new ArrayStrategy());
        STRING_STRATEGY_MAP.put(Strategy.Type.LINKED.name(), new LinkedStrategy());
    }

    public static Strategy getStrategy(String type) {
        Assert.notNull(type, "Expect type can not be null");
        return STRING_STRATEGY_MAP.get(type);
    }
}
