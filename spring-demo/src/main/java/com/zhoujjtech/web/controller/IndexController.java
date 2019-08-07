package com.zhoujjtech.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class  IndexController {

    private Log log = LogFactory.getLog(getClass());

    @RequestMapping("/index")
    public String index() {
        log.info("index...");
        return "jj";
    }
}
