package com.lsz.strategy.sort;

import java.io.File;

public class QuickSortStrategy implements SortStrategy {
    @Override
    public void sort(File file) {
        System.out.println(this.getClass().getCanonicalName());
    }
}
