package com.lsz.composite.demo.second;

public class Application {

    public static void main(String[] args) {
        Directory directory = new Directory("dubbo");
        directory.addSubNode(new File("providers"));
        directory.addSubNode(new File("consumers"));
        directory.addSubNode(new File("routers"));
        directory.addSubNode(new File("configurators"));
        final Directory directory1 = new Directory("dir");
        directory1.addSubNode(new File("file1"));
        directory1.addSubNode(new File("file2"));
        directory1.addSubNode(new File("file3"));

        directory.addSubNode(directory1);
        final int i = directory.countNumOfFiles();
        System.out.println("i = " + i);
        final long l = directory.countSizeOfFiles();
        System.out.println("l = " + l);
    }
}
