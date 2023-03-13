package com.lsz.util;

import java.util.HashMap;
import java.util.Map;

public class ApiRequest {

    private String originalUrl;
    private String token;
    private String appId;
    private long timestamp;

    public ApiRequest(String originalUrl, String token, String appId, long timestamp) {
        this.originalUrl = originalUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static ApiRequest buildFromFullUrl(String url) {
        try {
            int i = url.indexOf("?");
            if (i <= 0) {
            }
            String originalUrl = url.substring(0, i);
            url = url.substring(i + 1);

            Map<String, String> paramMap = new HashMap<String, String>();
            String[] params = url.split("&");
            for (String param : params) {
                String[] kv = param.split("=");
                paramMap.put(kv[0], kv[1]);
            }
            String token = paramMap.get(Constansts.AUTH_TOKEN_KEY);
            String appId = paramMap.get(Constansts.APP_ID_KEY);
            long timeStamp = Long.parseLong(paramMap.get(Constansts.TIMESTAMP_KEY));

            return new ApiRequest(originalUrl, token, appId, timeStamp);
        } catch (Exception exception) {
            throw new IllegalStateException("fail to transform url : " + url, exception);
        }
    }

    public String toFullUrlString() {
        final StringBuilder fullUrlString = new StringBuilder(originalUrl).append("?");
        fullUrlString
                .append(Constansts.APP_ID_KEY)
                .append(Constansts.EQUALS)
                .append(appId);

        fullUrlString
                .append(Constansts.AND)
                .append(Constansts.TIMESTAMP_KEY)
                .append(Constansts.EQUALS)
                .append(timestamp);


        fullUrlString
                .append(Constansts.AND)
                .append(Constansts.AUTH_TOKEN_KEY)
                .append(Constansts.EQUALS)
                .append(token);

        return fullUrlString.toString();
    }

    private static boolean isOriginalParam(String key) {

        return !Constansts.APP_ID_KEY.equals(key)
                && !Constansts.AUTH_TOKEN_KEY.equals(key)
                && !Constansts.TIMESTAMP_KEY.equals(key);
    }

    public String getOriginalUrl() {
        return this.originalUrl;
    }

    public String getToken() {
        return this.token;
    }

    public String getAppId() {
        return this.appId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

}
