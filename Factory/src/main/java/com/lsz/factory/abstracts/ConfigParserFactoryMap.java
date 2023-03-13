package com.lsz.factory.abstracts;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ConfigParserFactoryMap {

    private static final Map<String, ConfigParserFactory> CONFIG_PARSER_FACTORY_MAP = new HashMap<>();
    static {
        CONFIG_PARSER_FACTORY_MAP.put("MAC", new MacSystemJsonRuleConfigParserFactory());
    }

    public static ConfigParserFactory getConfigParserFactory(String type) {
        if (StringUtils.isEmpty(type)) {
            throw new IllegalArgumentException("expect type can not be empty");
        }
        return CONFIG_PARSER_FACTORY_MAP.get(type);
    }
}
