package com.lsz.strategy.api;

import org.springframework.util.Assert;

/**
 * for Multiton（多例）
 */
public class MultitonStrategyFactory {

    public static Strategy getStrategy(String type) {
        Assert.notNull(type, "Expect type can not be null!");
        if (Strategy.Type.ARRAY.equals(type)) {
            return new ArrayStrategy();
        } else if (Strategy.Type.LINKED.equals(type)) {
            return new LinkedStrategy();
        }
        throw new IllegalArgumentException("Can not find type: " + type);
    }
}
