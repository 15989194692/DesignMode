package com.lsz.strategy.sort;

import java.util.ArrayList;
import java.util.List;

public class SingleSortStrategyFactory {

    private static final List<AlgRange> ALG_RANGES = new ArrayList<>(4);

    static {
        ALG_RANGES.add(new AlgRange(0, 100, new MergeSortStrategy()));
        ALG_RANGES.add(new AlgRange(100, 1000, new QuickSortStrategy()));
    }

    public static SortStrategy getSortStrategy(long length) {
        for (AlgRange algRange : ALG_RANGES) {
            if (algRange.inRange(length)) {
                return algRange.getSortStrategy();
            }
        }
        throw new IllegalArgumentException("Can not find SortStrategy by length: " + length);
    }
}
