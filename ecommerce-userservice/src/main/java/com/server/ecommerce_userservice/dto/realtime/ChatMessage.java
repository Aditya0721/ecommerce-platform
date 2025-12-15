package com.server.ecommerce_userservice.dto.realtime;

import java.util.Date;

public class ChatMessage {
    private String from;
    private String content;
    private Date time;

    public ChatMessage() {}
    public ChatMessage(String from, String content, Date time) {
        this.from = from; this.content = content; this.time = time;
    }
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public void setTime(Date time){this.time=time;}
    public Date getTime(){return this.time;}
}

