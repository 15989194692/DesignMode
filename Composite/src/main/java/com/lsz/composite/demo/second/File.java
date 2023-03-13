package com.lsz.composite.demo.second;

public class File extends FileSystemNode {
    public File(String path) {
        super(path);
    }
    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(getPath());
        return file.exists() ? file.length() : 0;
    }
}
