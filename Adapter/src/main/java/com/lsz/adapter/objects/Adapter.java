package com.lsz.adapter.objects;

import com.lsz.adapter.api.NeedAdaptee;
import com.lsz.adapter.api.Target;

public class Adapter implements Target {

    private NeedAdaptee needAdaptee;

    public Adapter(NeedAdaptee needAdaptee) {
        this.needAdaptee = needAdaptee;
    }

    @Override
    public void t1() {
        needAdaptee.na1();
    }

    @Override
    public void t2() {
        needAdaptee.na2();
    }

    @Override
    public void t3() {
        needAdaptee.na3();
    }
}
