package com.lsz.snapshot.mine;

public class InputText {

    private StringBuffer text = new StringBuffer();

    public void append(String text) {
        this.text.append(text);
    }

    public String getText() {
        return text.toString();
    }


}
