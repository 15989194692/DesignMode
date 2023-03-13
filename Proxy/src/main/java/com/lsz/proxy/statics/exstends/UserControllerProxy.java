package com.lsz.proxy.statics.exstends;

import com.lsz.proxy.api.impl.UserControllerImpl;

public class UserControllerProxy extends UserControllerImpl {

    @Override
    public void login() {
        final long start = System.currentTimeMillis();
        super.login();
        final long end = System.currentTimeMillis();
        System.out.println("cost = " + (end - start));
    }

    @Override
    public void register() {
        final long start = System.currentTimeMillis();
        super.register();
        final long end = System.currentTimeMillis();
        System.out.println("cost = " + (end - start));

    }
}
