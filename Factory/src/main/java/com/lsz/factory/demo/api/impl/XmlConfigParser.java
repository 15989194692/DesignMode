package com.lsz.factory.demo.api.impl;

import com.lsz.factory.demo.Bean;
import com.lsz.factory.demo.Ref;
import com.lsz.factory.demo.api.BeanConfig;
import com.lsz.factory.demo.api.ConfigParser;
import com.lsz.factory.demo.api.ConstructorArg;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlConfigParser implements ConfigParser {

    private static final Logger LOGGER = Logger.getLogger(XmlConfigParser.class.getName());

    @Override
    public List<BeanConfig> parse(InputStream configInputStream) {
//        Assert.checkNonNull(configInputStream, "inputstream can not be null");
        StringBuilder configText = new StringBuilder();
        while (true) {
            byte[] bytes = new byte[2048];
            int len = 0;
            try {
                while ((len = configInputStream.read(bytes)) > 0) {
                    configText.append(new String(bytes, 0, len));
                }
                return parse(configText.toString());
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "read file fail,cause by: " + e.getMessage(), e);
            }
        }
    }

    @Override
    public List<BeanConfig> parse(String configText) {
//        Assert.checkNonNull(configText, "beanConfig text can not be null");




        BeanConfig bean = new BeanConfig();
        bean.setClassName(Bean.class.getName());
        bean.setId("bean");
        ConstructorArg beanConstructorArg = new ConstructorArg.ConstructorArgBuilder()
                .arg("ref")
                .isRef(true)
                .build();
        ArrayList<ConstructorArg> constructorArgs = new ArrayList<>();
        constructorArgs.add(beanConstructorArg);
        bean.setConstructorArgs(constructorArgs);

        final BeanConfig ref = new BeanConfig();
        ref.setClassName(Ref.class.getName());
        ref.setId("ref");
        ConstructorArg refConstructorArg = new ConstructorArg.ConstructorArgBuilder()
                .arg("name")
                .isRef(false)
                .type(String.class)
                .build();
        ArrayList<ConstructorArg> refConstructorArgs = new ArrayList<>();
        refConstructorArgs.add(refConstructorArg);
        ref.setConstructorArgs(refConstructorArgs);

        ArrayList<BeanConfig> beanConfigs = new ArrayList<>();
        beanConfigs.add(bean);
        beanConfigs.add(ref);
        return beanConfigs;
    }
}
