package com.lsz.strategy.sort;

public class AlgRange {

    private long start;
    private long end;
    private SortStrategy sortStrategy;

    public AlgRange(long start, long end, SortStrategy sortStrategy) {
        this.start = start;
        this.end = end;
        this.sortStrategy = sortStrategy;
    }

    public boolean inRange(long length) {
        return length >= start && length < end;
    }

    public SortStrategy getSortStrategy() {
        return sortStrategy;
    }
}
