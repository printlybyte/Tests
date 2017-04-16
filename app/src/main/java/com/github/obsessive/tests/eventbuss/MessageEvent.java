package com.github.obsessive.tests.eventbuss;

/**
 * Created by liuguodong on 2017/4/10.
 */

public class MessageEvent {

    public final String message;

    public String getMessage() {
        return message;
    }

    public MessageEvent(String message) {
        this.message = message;
    }
}