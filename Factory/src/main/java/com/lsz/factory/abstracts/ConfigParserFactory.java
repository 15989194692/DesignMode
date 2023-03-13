package com.lsz.factory.abstracts;

import com.lsz.factory.api.RuleConfigParser;
import com.lsz.factory.api.SystemConfigParser;

/**
 * 抽象工厂模式，适用与创建多种类型对象的场景
 */
public interface ConfigParserFactory {
    RuleConfigParser getRuleConfigParser();

    SystemConfigParser getSystemConfigParser();

}
