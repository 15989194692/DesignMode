package com.lsz.util;

public interface CredentialStorage {

    /**
     * 根据 appId 获取密码
     * @param appId 应用id
     * @return appId对应的密码
     */
    String getPasswordByAppId(String appId);
}
