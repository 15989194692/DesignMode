package com.lsz.factory.method;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParserFactoryMap {

    private static final Map<String, RuleConfigParserFactory> RULE_CONFIG_PARSER_FACTORY_MAP = new HashMap<>(2, 1.0F);
    static {
        RULE_CONFIG_PARSER_FACTORY_MAP.put("json", new JsonRuleConfigParserFactory());
        RULE_CONFIG_PARSER_FACTORY_MAP.put("xml", new XmlRuleConfigParserFactory());
    }


    public static RuleConfigParserFactory getRuleConfigParserFactory(String type) {
        if (StringUtils.isEmpty(type)) {
            throw new IllegalArgumentException("expect type can not be emty");
        }
        return RULE_CONFIG_PARSER_FACTORY_MAP.get(type);
    }
}
