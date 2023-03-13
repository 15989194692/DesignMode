package com.lsz.adapter.demo.filter;

public class CSensitiveWordsFilterAdapter extends CSensitiveWordsFilter implements TargetSensitiveWordsFilter {
    @Override
    public String filter(String text) {
        return super.filter(text, null);
    }
}
