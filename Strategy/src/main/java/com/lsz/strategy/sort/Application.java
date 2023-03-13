package com.lsz.strategy.sort;

import java.io.File;

public class Application {


    public static void main(String[] args) {
        final File file = new File("");
        final SortStrategy sortStrategy = SingleSortStrategyFactory.getSortStrategy(file.length());
        sortStrategy.sort(file);
    }
}
