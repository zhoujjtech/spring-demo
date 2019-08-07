package com.zhoujjtech.event;

import org.springframework.context.ApplicationEvent;

public class SendEmailEvent extends ApplicationEvent {

    public SendEmailEvent(Object source) {
        super(source);
    }
}
