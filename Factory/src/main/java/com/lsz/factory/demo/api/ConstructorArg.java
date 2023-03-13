package com.lsz.factory.demo.api;

import java.util.Objects;

public class ConstructorArg {
    private boolean isRef;

    private Class type;

    private Object arg;

    public ConstructorArg() {}

    private ConstructorArg(boolean isRef, Class type, Object arg) {
        this.isRef = isRef;
        this.type = type;
        this.arg = arg;
    }

    public boolean isRef() {
        return isRef;
    }

    public void setRef(boolean ref) {
        isRef = ref;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public Object getArg() {
        return arg;
    }

    public void setArg(Object arg) {
        this.arg = arg;
    }


    public static class ConstructorArgBuilder {
        private boolean isRef;
        private Class type;
        private Object arg;

        public ConstructorArgBuilder isRef(boolean isRef) {
            this.isRef = isRef;
            return this;
        }

        public ConstructorArgBuilder type(Class type) {
            this.type = type;
            return this;
        }

        public ConstructorArgBuilder arg(Object arg) {
            this.arg = arg;
            return this;
        }

        public ConstructorArg build() {
            if (Objects.isNull(isRef) || Objects.isNull(arg)) {
                throw new IllegalArgumentException("need 'isRef' or 'arg'");
            }
            if (!isRef && Objects.isNull(type)) {
                throw new IllegalArgumentException("need 'type'");
            }
            return new ConstructorArg(isRef, type, arg);
        }
    }
}
