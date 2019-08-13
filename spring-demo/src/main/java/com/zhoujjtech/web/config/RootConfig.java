package com.zhoujjtech.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.mvc.Controller;

/*@Configuration
@ComponentScan(basePackages = "com.zhoujjtech.web", excludeFilters =
                {@ComponentScan.Filter(value= Controller.class),
                @ComponentScan.Filter(value= WebConfig.class, type= FilterType.ASSIGNABLE_TYPE)})*/
public class RootConfig {

}
