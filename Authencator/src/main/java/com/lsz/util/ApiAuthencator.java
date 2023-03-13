package com.lsz.util;

public interface ApiAuthencator {

    /**
     * 权限校验
     * @param url 带令牌的 url
     * @return 校验是否通过
     */
    boolean auth(String url);

    /**
     * 权限校验
     * @param apiRequest 请求链接
     * @return 校验是否通过
     */
    boolean auth(ApiRequest apiRequest);

    /**
     * 生成Token并拼接到url上
     * @param originUrl 初始url
     * @param appId appId
     * @param password 密码
     * @param timestamp 时间戳
     * @return 拼接了token的url
     */
    String generateUrlWithToken(String originUrl, String appId, String password, long timestamp);
}
