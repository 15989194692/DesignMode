package com.lsz.adapter.demo.cd;

public class Application {

    public static void main(String[] args) {
        CDAdapter cdAdapter = new CDAdapter();
        cdAdapter.function1();
        cdAdapter.function2();
        cdAdapter.function3(new CDParam());
        cdAdapter.function4();
    }
}
