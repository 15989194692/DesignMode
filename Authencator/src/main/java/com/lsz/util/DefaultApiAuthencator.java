package com.lsz.util;

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

    public static void main(String[] args) {
        ApiAuthencator defaultApiAuthencator = new DefaultApiAuthencator();
        String originalUrl = "localhost:2181/lsz/user?appId=lsz&timestamp=" + (System.currentTimeMillis() - 2323);
        AuthToken clientAuthToken = AuthToken.generate("localhost:2181/lsz/user?", "lsz1", "LSZZSL", System.currentTimeMillis() - 2323);
        String newUrl = originalUrl + "&token=" + clientAuthToken.getToken();
        final boolean auth = defaultApiAuthencator.auth(newUrl);
        System.out.println("auth = " + auth);

    }
}
