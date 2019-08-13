package com.zhoujjtech.web.controller;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    private Log log = LogFactory.getLog(getClass());

    @RequestMapping("/index")
    @ResponseBody
    public Map index() {

        Map<String, Object> map = new HashMap<>();
        map.put("key", "zhoujjtech");

        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        return map;

    }
}
