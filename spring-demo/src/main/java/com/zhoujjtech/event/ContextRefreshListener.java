package com.zhoujjtech.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshListener implements ApplicationListener<ContextRefreshedEvent> {

    private Log log = LogFactory.getLog(getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("监听到消息...contextRefreshedEvent");
    }

}