package com.lsz.builder.mine;

import org.apache.commons.lang3.StringUtils;

public class ResourcePoolConfig {

    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;


    private ResourcePoolConfig(String name, int maxTotal, int maxIdle, int minIdle) {
        this.name = name;
        this.maxTotal = maxTotal;
        this.maxIdle = maxIdle;
        this.minIdle = minIdle;
    }

    @Override
    public String toString() {
        return "ResourcePoolConfig{" +
                "name='" + name + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", minIdle=" + minIdle +
                '}';
    }

    public static class ResourcePoolConfigBuilder {
        private String name;
        private int maxTotal;
        private int maxIdle;
        private int minIdle;

        public ResourcePoolConfigBuilder(String name) {
            this.name = name;
        }

        public ResourcePoolConfigBuilder maxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public ResourcePoolConfigBuilder maxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
            return this;
        }

        public ResourcePoolConfigBuilder minIdle(int minIdle) {
            this.minIdle = minIdle;
            return this;
        }

        public ResourcePoolConfig build() {
            //可以对变量做一些判断逻辑
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("...");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig(name, maxTotal, maxIdle, minIdle);
        }
    }

}
