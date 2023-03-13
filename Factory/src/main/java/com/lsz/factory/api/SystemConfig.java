package com.lsz.factory.api;

public class SystemConfig {
    private String os;

    public SystemConfig() {}

    public SystemConfig(String os) {
        this.os = os;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "SystemConfig{" +
                "os='" + os + '\'' +
                '}';
    }
}
