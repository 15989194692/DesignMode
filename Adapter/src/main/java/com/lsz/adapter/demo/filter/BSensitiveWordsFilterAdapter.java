package com.lsz.adapter.demo.filter;

public class BSensitiveWordsFilterAdapter extends BSensitiveWordsFilter implements TargetSensitiveWordsFilter {
    @Override
    public String filter(String text) {
        return super.filters(text);
    }
}
