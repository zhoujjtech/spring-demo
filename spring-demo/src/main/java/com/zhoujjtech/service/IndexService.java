package com.zhoujjtech.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

//@Scope("prototype")
//@Component("indexService")
public class IndexService implements IndexInterface{

    private Log log = LogFactory.getLog(IndexService.class.getName());

    @Autowired
    private OrderService orderService;

/*    public IndexService(OrderService orderService) {

    }*/

/*
    @PostConstruct // TODO: 2019-08-05 后置处理来处理
    public void init() {
        log.info("@PostConstruct....");
    }

    public void initMethod() {
        log.info("initMethod....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet..");
    }
*/

    @Transactional
    public void saveIndex() {

    }
}
