package com.lsz.factory.api.impl;

import com.lsz.factory.api.RuleConfig;
import com.lsz.factory.api.RuleConfigParser;

public class JsonRuleConfigParser implements RuleConfigParser {

    private static final String TYPE = "JSON";


    public RuleConfig parse(String configText) {
        return new RuleConfig(TYPE);
    }
}
