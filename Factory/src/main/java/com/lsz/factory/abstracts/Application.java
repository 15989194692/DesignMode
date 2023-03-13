package com.lsz.factory.abstracts;

import com.lsz.factory.api.RuleConfig;
import com.lsz.factory.api.RuleConfigParser;
import com.lsz.factory.api.SystemConfig;
import com.lsz.factory.api.SystemConfigParser;

public class Application {

    public static void main(String[] args) {
        final ConfigParserFactory mac = ConfigParserFactoryMap.getConfigParserFactory("MAC");
        final RuleConfigParser ruleConfigParser = mac.getRuleConfigParser();
        final RuleConfig parse = ruleConfigParser.parse("");
        System.out.println("parse = " + parse);
        final SystemConfigParser systemConfigParser = mac.getSystemConfigParser();
        final SystemConfig parse1 = systemConfigParser.parse("");
        System.out.println("parse1 = " + parse1);
    }
}
