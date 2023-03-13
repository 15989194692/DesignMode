package com.lsz.snapshot.mine;

import java.util.Scanner;
import java.util.Stack;

public class SnapshotInputTextHolder {

    private Stack<InputText> snapshots = new Stack<InputText>();

    public InputText undo() {
        return snapshots.pop();
    }

    public void pushSnapshot(InputText inputText) {
        final InputText deepCopyInputText = new InputText();
        deepCopyInputText.append(inputText.getText());
        snapshots.push(deepCopyInputText);
    }

    public String list() {
        return snapshots.isEmpty() ? "" : snapshots.peek().getText();
    }

    public static void main(String[] args) {
        final SnapshotInputTextHolder snapshotInputTextHolder = new SnapshotInputTextHolder();
        InputText inputText = new InputText();
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String text = scanner.next();
            if (":quit".equals(text)) {
                break;
            } else if (":list".equals(text)) {
                System.out.println(inputText.getText());
            } else if (":undo".equals(text)) {
                inputText = snapshotInputTextHolder.undo();
                System.out.println(inputText.getText());
            } else {
                snapshotInputTextHolder.pushSnapshot(inputText);
                inputText.append(text);
            }
        }
    }


}
