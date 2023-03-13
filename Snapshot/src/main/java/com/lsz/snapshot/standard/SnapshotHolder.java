package com.lsz.snapshot.standard;

import java.util.Scanner;
import java.util.Stack;

public class SnapshotHolder {

    private Stack<Snapshot> snapshots = new Stack<>();

    public Snapshot undo() {
        if (snapshots.isEmpty()) {
            throw new IllegalArgumentException("无法进行回退");
        }
        return snapshots.pop();
    }

    public void pushSnapshot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }


}

class Application {
    public static void main(String[] args) {
        final SnapshotHolder snapshotHolder = new SnapshotHolder();
        final InputText inputText = new InputText();
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String text = scanner.next();
            if (":quit".equals(text)) {
                break;
            } else if (":list".equals(text)) {
                System.out.println(inputText.getText());
            } else if (":undo".equals(text)) {
                final Snapshot prevSnapshot = snapshotHolder.undo();
                inputText.restoreSnapshot(prevSnapshot);
                System.out.println(inputText.getText());
            } else {
                final Snapshot snapshot = new Snapshot(inputText.getText());
                snapshotHolder.pushSnapshot(snapshot);
                inputText.append(text);
            }
        }
    }
}
