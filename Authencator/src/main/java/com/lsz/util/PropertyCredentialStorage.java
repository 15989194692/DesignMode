package com.lsz.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyCredentialStorage implements CredentialStorage {
    /*
    日志打印
     */
    private static final Logger LOGGER = Logger.getLogger(PropertyCredentialStorage.class.getName());

    /*
    应用密码配置文件路径
     */
    private static final String PROPERTY_PATH = "pass.property";

    /*
    用于保持加载配置所得的 properties 变量
     */
    private static final Holder<Properties> PROPERTIES_HOLDER = new Holder<>();

    static {
        try(InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTY_PATH)) {
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            PROPERTIES_HOLDER.set(properties);
        } catch (IOException ioException) {
            LOGGER.log(Level.SEVERE, "fail to load property which file path is : " + PROPERTY_PATH, ioException);
            // 避免 NullPointerException
            PROPERTIES_HOLDER.set(new Properties());
        }
    }

    @Override
    public String getPasswordByAppId(String appId) {
        return PROPERTIES_HOLDER.get().getProperty(appId);
    }
}
