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
}
