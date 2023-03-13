package com.lsz.factory.abstracts;

import com.lsz.factory.api.RuleConfigParser;
import com.lsz.factory.api.SystemConfigParser;
import com.lsz.factory.api.impl.JsonRuleConfigParser;
import com.lsz.factory.api.impl.MacSystemConfigParser;

public class MacSystemJsonRuleConfigParserFactory implements ConfigParserFactory {
    @Override
    public RuleConfigParser getRuleConfigParser() {
        return new JsonRuleConfigParser();
    }

    @Override
    public SystemConfigParser getSystemConfigParser() {
        return new MacSystemConfigParser();
    }
}
