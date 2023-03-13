package com.lsz.proxy.api.impl;

import com.lsz.proxy.api.UserController;

public class UserControllerImpl implements UserController {
    @Override
    public void login() {
        //TODO 登陆逻辑
        System.out.println("登陆成功！");
    }

    @Override
    public void register() {
        //TODO 注册逻辑
        System.out.println("注册成功！");
    }
}
