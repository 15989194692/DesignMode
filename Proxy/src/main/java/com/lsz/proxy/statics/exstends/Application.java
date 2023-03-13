package com.lsz.proxy.statics.exstends;

public class Application {
    public static void main(String[] args) {
        final UserControllerProxy userControllerProxy = new UserControllerProxy();
        userControllerProxy.login();
        userControllerProxy.register();
    }
}
