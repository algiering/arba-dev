package com.arba.multitypelistview.model;

import android.widget.TextView;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ModelComment {
    private String textMessage;
    private String textWriter;

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getTextWriter() {
        return textWriter;
    }

    public void setTextWriter(String textWriter) {
        this.textWriter = textWriter;
    }

    public ModelComment(String textMessage, String textWriter) {
        this.textMessage = textMessage;
        this.textWriter = textWriter;
    }

    public ModelComment() {
    }
}
