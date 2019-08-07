package com.zhoujjtech.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component
public class EmailListener implements ApplicationListener<SendEmailEvent> {

    private Log log = LogFactory.getLog(getClass());

    @Override
    public void onApplicationEvent(SendEmailEvent event) {
        log.info("监听到消息...");
    }

}