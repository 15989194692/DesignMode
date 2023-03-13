package com.lsz.composite.demo.second;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemNode {

    private List<FileSystemNode> subNodes;

    public Directory(String path) {
        super(path);
        subNodes = new ArrayList<>();
    }

    @Override
    public int countNumOfFiles() {
        int totalNum = 0;
        for (FileSystemNode fileSystemNode : subNodes) {
            totalNum += fileSystemNode.countNumOfFiles();
        }
        return totalNum;
    }

    @Override
    public long countSizeOfFiles() {
        long totalSize = 0;
        for (FileSystemNode fileSystemNode : subNodes) {
            totalSize += fileSystemNode.countSizeOfFiles();
        }
        return totalSize;
    }

    public void addSubNode(FileSystemNode fileSystemNode) {
        subNodes.add(fileSystemNode);
    }

    public void removeSubNode(FileSystemNode fileSystemNode) {
        int curator = 0;
        for (FileSystemNode subNode : subNodes) {
            if (subNode.getPath().equals(fileSystemNode.getPath())) {
                subNodes.remove(curator);
                break;
            }
            curator++;
        }
    }
}
