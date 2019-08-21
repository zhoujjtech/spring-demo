package com.zhoujjtech.service;

import com.zhoujjtech.annotation.SkipConditional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Scope("prototype")
@Component("orderService")
//@SkipConditional
public class OrderService {

    private Log log = LogFactory.getLog(OrderService.class.getName());

//    public OrderService() {
////        log.info("构造方法...");
//    }

    @Autowired
    private IndexService indexService;

}
