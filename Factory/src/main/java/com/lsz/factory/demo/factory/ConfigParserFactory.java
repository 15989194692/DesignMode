package com.lsz.factory.demo.factory;

import com.lsz.factory.demo.api.ConfigParser;
import com.lsz.factory.demo.api.impl.XmlConfigParser;
import org.apache.commons.lang3.StringUtils;

import java.rmi.NoSuchObjectException;
import java.util.HashMap;
import java.util.Map;

public class ConfigParserFactory {

    private static final Map<String, ConfigParser> CONFIG_PARSER_MAP = new HashMap<>(1, 1.0F);

    static {
        CONFIG_PARSER_MAP.put("XML", new XmlConfigParser());
    }

    public static ConfigParser getConfigParser(String type) throws NoSuchObjectException {
        if (StringUtils.isEmpty(type)) {
            throw new IllegalArgumentException("expect type can not be empty");
        }
        ConfigParser configParser = CONFIG_PARSER_MAP.get(type);
        if (configParser == null) {
            throw new NoSuchObjectException("can not find such ConfigParser");
        }
        return CONFIG_PARSER_MAP.get(type);
    }
}
