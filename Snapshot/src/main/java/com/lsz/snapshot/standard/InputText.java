package com.lsz.snapshot.standard;

public class InputText {

    private StringBuffer text = new StringBuffer();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        this.text.append(input);
    }

    public Snapshot createSnapshot() {
        return new Snapshot(text.toString());
    }

    public void restoreSnapshot(Snapshot snapshot) {
        this.text.replace(0, text.length(), snapshot.getText());
    }
}
