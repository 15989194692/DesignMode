package com.lsz.util;

import org.apache.commons.codec.digest.DigestUtils;

public class DefaultApiAuthencator implements ApiAuthencator {

    private CredentialStorage credentialStorage;

    public DefaultApiAuthencator(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }

    public DefaultApiAuthencator() {
        this.credentialStorage = new PropertyCredentialStorage();
    }


    @Override
    public boolean auth(String url) {
        ApiRequest apiRequest = ApiRequest.buildFromFullUrl(url);
        return auth(apiRequest);
    }

    @Override
    public boolean auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        String originalUrl = apiRequest.getOriginalUrl();

        AuthToken authToken = new AuthToken(token, timestamp);
        if (authToken.isExpired()) {
            return false;
        }

        String password = credentialStorage.getPasswordByAppId(appId);
        AuthToken serviceToken = AuthToken.generate(originalUrl, appId, password, timestamp);
        return serviceToken.match(authToken);
    }

    @Override
    public String generateUrlWithToken(String originUrl, String appId, String password, long timestamp) {
        AuthToken clientToken = AuthToken.generate(originUrl, appId, password, timestamp);
        return new ApiRequest(originUrl, clientToken.getToken(), appId, timestamp).toFullUrlString();
    }

    public static void main(String[] args) {
        ApiAuthencator defaultApiAuthencator = new DefaultApiAuthencator();

        String originUrl = "localhost:2181/lsz/user";
        String appId = "lsz";
        String password = "LSZZSL";
        long timeStamp = System.currentTimeMillis() - 2323;
        String apiUrl = defaultApiAuthencator.generateUrlWithToken(originUrl, appId, password, timeStamp);

        // TODO 访问

        boolean auth1 = defaultApiAuthencator.auth(apiUrl);
        System.out.println("auth1 = " + auth1);


        final String s = DigestUtils.md5Hex("localhost:2181/lsz/user/appId=lsz&password=LSZZSL&timestamp=1678712027843".getBytes());
        System.out.println("s = " + s);

        final String s1 = DigestUtils.md5Hex("localhost:2181/lsz/user/appId=lsz&password=LSZZSL&timestamp=1678712027843".getBytes());
        System.out.println("s = " + s1);
        /*String originalUrl = "localhost:2181/lsz/user?appId=lsz&timestamp=" + (System.currentTimeMillis() - 2323);
        AuthToken clientAuthToken = AuthToken.generate("localhost:2181/lsz/user?", "lsz1", "LSZZSL", System.currentTimeMillis() - 2323);
        String newUrl = originalUrl + "&token=" + clientAuthToken.getToken();
        final boolean auth = defaultApiAuthencator.auth(newUrl);
        System.out.println("auth = " + auth);*/

    }
}
