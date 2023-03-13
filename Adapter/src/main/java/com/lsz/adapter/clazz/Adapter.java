package com.lsz.adapter.clazz;

import com.lsz.adapter.api.Target;
import com.lsz.adapter.api.NeedAdaptee;

public class Adapter extends NeedAdaptee implements Target {

    @Override
    public void t1() {
        super.na1();
    }

    @Override
    public void t2() {
        super.na2();
    }

    @Override
    public void t3() {
        super.na3();
    }
}
