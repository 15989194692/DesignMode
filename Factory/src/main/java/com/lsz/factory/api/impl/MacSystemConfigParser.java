package com.lsz.factory.api.impl;

import com.lsz.factory.api.SystemConfig;
import com.lsz.factory.api.SystemConfigParser;

public class MacSystemConfigParser implements SystemConfigParser {
    private static final String OS = "MAC";

    @Override
    public SystemConfig parse(String configText) {
        return new SystemConfig(OS);
    }
}
