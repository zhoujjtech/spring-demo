package com.zhoujjtech;

import com.zhoujjtech.config.AppConfig;
import com.zhoujjtech.dao.IndexDaoMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BootApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
//        context.addBeanFactoryPostProcessor(new IndexBeanFactoryPostProcessor());
        context.refresh();
//        context.scan("com.zhoujjtech");
        Object bean = context.getBean("indexFactoryBean");
//        System.out.println(bean.toString());
//        System.out.println(context.getBean(IndexService.class));

    }
}
