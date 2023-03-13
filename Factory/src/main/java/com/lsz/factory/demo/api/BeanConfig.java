package com.lsz.factory.demo.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeanConfig {

    private String id;
    private String className;
    private List<ConstructorArg> constructorArgs = Collections.emptyList();
    private boolean lazyInit = false;
    private Scope scope = Scope.SINGLETON;

    public boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }

    public void setConstructorArgs(List<ConstructorArg> constructorArgs) {
        this.constructorArgs = constructorArgs;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    private enum Scope {
        SINGLETON,
        PROTOTYPE
    }
}


