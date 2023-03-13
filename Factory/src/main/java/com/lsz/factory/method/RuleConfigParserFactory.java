package com.lsz.factory.method;

import com.lsz.factory.api.RuleConfigParser;

/**
 * 工厂方法模式，适用于创建复杂对象的场景
 */
public interface RuleConfigParserFactory {
    RuleConfigParser getRuleConfigParser();
}
