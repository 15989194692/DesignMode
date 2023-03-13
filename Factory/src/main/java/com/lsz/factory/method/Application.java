package com.lsz.factory.method;

import com.lsz.factory.api.RuleConfig;
import com.lsz.factory.api.RuleConfigParser;

public class Application {

    public static void main(String[] args) {
        RuleConfigParserFactory ruleConfigParserFactory = RuleConfigParserFactoryMap.getRuleConfigParserFactory("xml");
        RuleConfigParser ruleConfigParser = ruleConfigParserFactory.getRuleConfigParser();
        final RuleConfig parse = ruleConfigParser.parse("");
        System.out.println("parse = " + parse);



    }
}
