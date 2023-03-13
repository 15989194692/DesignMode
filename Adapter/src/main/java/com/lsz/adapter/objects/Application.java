package com.lsz.adapter.objects;

import com.lsz.adapter.api.NeedAdaptee;

public class Application {

    public static void main(String[] args) {
        final Adapter adapter = new Adapter(new NeedAdaptee());
        adapter.t1();
        adapter.t2();
        adapter.t3();
    }
}
