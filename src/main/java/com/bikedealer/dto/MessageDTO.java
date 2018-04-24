package com.bikedealer.dto;

import java.awt.*;

public class MessageDTO {
    private String message;
    private TrayIcon.MessageType type;

    public MessageDTO() {
        super();
    }

    public MessageDTO(TrayIcon.MessageType type, String message) {
        super();
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TrayIcon.MessageType getType() {
        return type;
    }

    public void setType(TrayIcon.MessageType type) {
        this.type = type;
    }
}
