package com.main.hw.models;

public class Message
{
    private String text;
    private String sender;

    public Message() {
    }
    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
