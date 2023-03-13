package com.lsz.factory.api.impl;

import com.lsz.factory.api.RuleConfig;
import com.lsz.factory.api.RuleConfigParser;

public class XmlRuleConfigParser implements RuleConfigParser {
    private static final String TYPE = "XML";

    public RuleConfig parse(String configText) {
        return new RuleConfig(TYPE);
    }
}
