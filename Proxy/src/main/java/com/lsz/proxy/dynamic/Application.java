package com.lsz.proxy.dynamic;

import com.lsz.proxy.api.UserController;
import com.lsz.proxy.api.impl.UserControllerImpl;

public class Application {

    public static void main(String[] args) {
        final UserController proxy = (UserController) CostProxyHelper.createProxy(new UserControllerImpl());
        proxy.login();
        proxy.register();
    }
}
