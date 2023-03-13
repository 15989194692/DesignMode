package com.lsz.adapter.demo.filter;

public class ASensitiveWordsFilterAdapter extends ASensitiveWordsFilter implements TargetSensitiveWordsFilter {
    @Override
    public String filter(String text) {
        return super.filterSexyWords(text);
    }
}
