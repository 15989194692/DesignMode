package com.lsz.factory.api;

public class RuleConfig {

    private String type;

    public RuleConfig() {}

    public RuleConfig(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RuleConfig{" +
                "type='" + type + '\'' +
                '}';
    }
}
