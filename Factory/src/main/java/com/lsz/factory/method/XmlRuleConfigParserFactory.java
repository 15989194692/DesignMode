package com.lsz.factory.method;

import com.lsz.factory.api.RuleConfigParser;
import com.lsz.factory.api.impl.XmlRuleConfigParser;

public class XmlRuleConfigParserFactory implements RuleConfigParserFactory {
    @Override
    public RuleConfigParser getRuleConfigParser() {
        return new XmlRuleConfigParser();
    }
}
