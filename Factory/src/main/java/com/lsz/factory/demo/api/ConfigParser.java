package com.lsz.factory.demo.api;

import java.io.InputStream;
import java.util.List;

public interface ConfigParser {
    List<BeanConfig> parse(InputStream configInputStream);
    List<BeanConfig> parse(String configInputText);
}
