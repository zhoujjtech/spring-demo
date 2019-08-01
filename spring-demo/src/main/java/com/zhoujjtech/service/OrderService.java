package com.zhoujjtech.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("orderService")
public class OrderService {

    private Log log = LogFactory.getLog(OrderService.class.getName());

//    public OrderService() {
////        log.info("构造方法...");
//    }

    @Autowired
    private IndexService indexService;

    @PostConstruct
    public void init() {
        log.info("初始化方法....");
    }
}
