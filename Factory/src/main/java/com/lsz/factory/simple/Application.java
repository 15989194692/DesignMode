package com.lsz.factory.simple;

import com.lsz.factory.api.RuleConfig;
import com.lsz.factory.api.RuleConfigParser;

public class Application {

    public static void main(String[] args) {
        RuleConfigParser json = RuleConfigParserFactory.getRuleConfigParser("json");
        System.out.println("json = " + json);
        final RuleConfig parse = json.parse("");
        System.out.println("parse = " + parse);

        final RuleConfigParser xml = RuleConfigParserFactory.getRuleConfigParser("xml");
        System.out.println("xml = " + xml);
        final RuleConfig parse1 = xml.parse("");
        System.out.println("parse1 = " + parse1);
    }
}
