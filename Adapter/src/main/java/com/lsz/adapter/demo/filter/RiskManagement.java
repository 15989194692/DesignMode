package com.lsz.adapter.demo.filter;

import java.util.ArrayList;
import java.util.List;

public class RiskManagement {

    private List<TargetSensitiveWordsFilter> sensitiveWordsFilters;

    public RiskManagement() {
        this.sensitiveWordsFilters = new ArrayList<>();
    }

    public void addFilter(TargetSensitiveWordsFilter sensitiveWordsFilter) {
        sensitiveWordsFilters.add(sensitiveWordsFilter);
    }

    public String filter(String text) {
        for (TargetSensitiveWordsFilter sensitiveWordsFilter : sensitiveWordsFilters) {
            text = sensitiveWordsFilter.filter(text);
        }

        return text;
    }
}
