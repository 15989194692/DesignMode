package com.lsz.composite.demo.first;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSystemNode {

    private String path;
    private boolean isFile;
    private List<FileSystemNode> subNodes = new ArrayList<>();

    public FileSystemNode(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    public int countNumOfFiles() {
        if (isFile) {
            return 1;
        }
        int totalSum = 0;
        for (FileSystemNode fileSystemNode : subNodes) {
            totalSum += fileSystemNode.countNumOfFiles();
        }
        return totalSum;
    }

    public long countSizeOfFiles() {
        if (isFile) {
            final File file = new File(path);
            if (!file.exists()) {
                return 0;
            }
            return file.length();
        }
        long totalSize = 0;
        for (FileSystemNode fileSystemNode : subNodes) {
            totalSize += fileSystemNode.countSizeOfFiles();
        }
        return totalSize;
    }

    public void addSubNode(FileSystemNode fileSystemNode) {
        if (isExist(fileSystemNode)) {
            return;
        }
        subNodes.add(fileSystemNode);
    }

    public void removeSubNode(FileSystemNode fileSystemNode) {
        for (FileSystemNode subNode : subNodes) {
            if (subNode.equals(fileSystemNode)) {
                subNodes.remove(fileSystemNode);
            }
        }
    }

    private boolean isExist(FileSystemNode fileSystemNode) {
        for (FileSystemNode subNode : subNodes) {
            if (subNode.equals(fileSystemNode)) {
                return true;
            }
        }
        return false;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

}
