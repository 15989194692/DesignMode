package com.lsz.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

public class AuthToken {
    /*
    Token 默认过期时间
     */
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;

    private static final String SPRIT = "/";

    private static final String AND = "&";

    private static final String EQUAL = "=";

    /*
    令牌
     */
    private String token;

    /*
    时间戳
     */
    private long timestamp;

    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long timestamp) {
        this.token = token;
        this.timestamp = timestamp;
    }

    public AuthToken(String token, long timestamp, long expiredTimeInterval) {
        this.token = token;
        this.timestamp = timestamp;
        this.expiredTimeInterval = expiredTimeInterval;
    }


    /**
     * 生成一个令牌
     * @param originalUrl 原始的 api 请求链接
     * @param appId 应用id
     * @param password 密码
     * @param timestamp 时间戳
     * @return 新生成的令牌
     */
    public static AuthToken generate(String originalUrl, String appId, String password, long timestamp) {
        StringBuilder authTokenBuilder =
                new StringBuilder(originalUrl);
        authTokenBuilder
                .append(SPRIT)
                .append(Constansts.APP_ID_KEY)
                .append(EQUAL)
                .append(appId);
        authTokenBuilder
                .append(AND)
                .append(Constansts.PASSWORD_KEY)
                .append(EQUAL)
                .append(password);
        authTokenBuilder
                .append(AND)
                .append(Constansts.TIMESTAMP_KEY)
                .append(EQUAL)
                .append(timestamp);

        String token = DigestUtils.md5Hex(authTokenBuilder.toString().getBytes());
        return new AuthToken(token, timestamp);
    }

    public String getToken() {
        return token;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    /**
     * 检查令牌是否已经过期了
     * @return 令牌是否已经过期
     */
    public boolean isExpired() {
        return System.currentTimeMillis() - timestamp >= expiredTimeInterval;
    }

    /**
     * 检查两个 {@link AuthToken} 是否一致
     * @param authToken 权限令牌
     * @return 两个权限令牌是否一致
     */
    public boolean match(AuthToken authToken) {
        return this.hashCode() == authToken.hashCode() && this.equals(authToken);
    }

    @Override
    public int hashCode() {
        return hashCode(token, timestamp);
    }

    private int hashCode(Object... params) {
        return Arrays.hashCode(params);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        AuthToken authToken = (AuthToken)obj;
        return authToken.getToken().equals(this.token) && authToken.getTimestamp() == this.timestamp;
    }

}
