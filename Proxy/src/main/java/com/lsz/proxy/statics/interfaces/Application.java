package com.lsz.proxy.statics.interfaces;

import com.lsz.proxy.api.impl.UserControllerImpl;

public class Application {

    public static void main(String[] args) {
        final UserControllerProxy userControllerProxy = new UserControllerProxy(new UserControllerImpl());
        userControllerProxy.login();
        userControllerProxy.register();
    }
}
