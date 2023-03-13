package com.lsz.proxy.statics.interfaces;

import com.lsz.proxy.api.UserController;

public class UserControllerProxy implements UserController {

    private UserController userController;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void login() {
        final long start = System.currentTimeMillis();
        userController.login();
        final long end = System.currentTimeMillis();
        System.out.println(" (cost = " +  (end - start));
    }

    @Override
    public void register() {
        final long start = System.currentTimeMillis();
        userController.register();
        final long end = System.currentTimeMillis();
        System.out.println(" (cost = " +  (end - start));
    }
}
