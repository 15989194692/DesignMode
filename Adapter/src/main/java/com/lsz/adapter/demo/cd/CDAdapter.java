package com.lsz.adapter.demo.cd;

public class CDAdapter extends CD implements CDTarget {
    @Override
    public void function1() {
        super.staticFunction1();
    }

    @Override
    public void function2() {
        super.uglyNamingFunction2();
    }

    @Override
    public void function3(CDParam cdParam) {
        super.tooManyParamsFunction3(cdParam.getParamA(), cdParam.getParamB(), cdParam.getParamC(), cdParam.getParamD(), cdParam.getParamE());
    }

    @Override
    public void function4() {
        // TODO ...reimplement it...
    }
}
