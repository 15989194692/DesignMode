package com.lsz.builder.mine;

public class Application {

    public static void main(String[] args) {
        final ResourcePoolConfig mysql = new ResourcePoolConfig.ResourcePoolConfigBuilder("mysql")
                .maxIdle(3)
                .maxTotal(2)
                .minIdle(1)
                .build();
        System.out.println("mysql = " + mysql);
    }
}
