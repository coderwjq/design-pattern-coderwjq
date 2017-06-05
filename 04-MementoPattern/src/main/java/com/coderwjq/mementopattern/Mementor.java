package com.coderwjq.mementopattern;

/**
 * @Created by coderwjq on 2017/6/5 16:14.
 * @Desc
 */

public class Mementor {
    private String text;
    private int cursor;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean equals(Object obj) {
        Mementor mementor = (Mementor) obj;
        if (this.text.equals(mementor.getText()) && this.cursor == mementor.getCursor()) {
            return true;
        } else {
            return false;
        }
    }
}
