package com.lsz.factory.simple;

import com.lsz.factory.api.RuleConfigParser;
import com.lsz.factory.api.impl.JsonRuleConfigParser;
import com.lsz.factory.api.impl.XmlRuleConfigParser;
import com.lsz.factory.util.Holder;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂模式，适用于构建简单对象的场景
 */
public class RuleConfigParserFactory {

    private static Map<String, RuleConfigParser> RULE_CONFIG_PARSER_MAP = new HashMap<String, RuleConfigParser>(2, 1.0F);

    static {
        RULE_CONFIG_PARSER_MAP.put("json", new JsonRuleConfigParser());
        RULE_CONFIG_PARSER_MAP.put("xml", new XmlRuleConfigParser());
    }
    
    public static RuleConfigParser getRuleConfigParser(String type) {
        if (StringUtils.isEmpty(type)) {
            throw new IllegalArgumentException("expect type can not be empy");
        }
        return RULE_CONFIG_PARSER_MAP.get(type);
    }





}
