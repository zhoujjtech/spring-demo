package com.zhoujjtech.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("indexService")
public class IndexService {

    private Log log = LogFactory.getLog(IndexService.class.getName());

    @Autowired
    private OrderService orderService;

/*    public IndexService(OrderService orderService) {

    }*/

    @PostConstruct
    public void init() {
        log.info("初始化方法....");
    }

}
