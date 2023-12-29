package com.lsz.factory.demo.api.impl;

import com.lsz.factory.demo.api.BeanConfig;
import com.lsz.factory.demo.api.ConfigParser;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Dom4jXmlConfigParser
 * @Description TODO
 * @Author lishuzeng
 * @Date 2023/12/29 下午5:20
 * @Version 1.0.0
 **/
public class Dom4jXmlConfigParser implements ConfigParser {

    private static final String ID = "id";

    private static final String CLASS = "class";

    @Override
    public List<BeanConfig> parse(InputStream configInputStream) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(configInputStream);
            Element rootElement = document.getRootElement();

            List<BeanConfig> beanConfigs = new ArrayList<>();
            for (Element element : (List<Element>) rootElement.elements()) {
                String beanID = element.attributeValue(ID);
                String beanClassName = element.attributeValue(CLASS);
                BeanConfig beanConfig = new BeanConfig();
                beanConfig.setClassName(beanClassName);
                beanConfig.setId(beanID);
                beanConfigs.add(beanConfig);
            }
            return beanConfigs;
        } catch (Exception exception) {
            System.out.println("exception = " + exception);
        }
        return Collections.emptyList();
    }

    @Override
    public List<BeanConfig> parse(String configInputText) {
        return null;
    }
}
