package com.lsz.factory.method;

import com.lsz.factory.api.RuleConfigParser;
import com.lsz.factory.api.impl.JsonRuleConfigParser;

/**
 *
 */
public class JsonRuleConfigParserFactory implements RuleConfigParserFactory {
    @Override
    public RuleConfigParser getRuleConfigParser() {
        return new JsonRuleConfigParser();
    }
}
