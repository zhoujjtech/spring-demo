package com.zhoujjtech;

import com.zhoujjtech.config.AppConfig;
import com.zhoujjtech.dao.IndexDaoMapper;
import com.zhoujjtech.dubbo.consumer.IndexComsumer;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BootApplication {

    public static void main(String[] args) {
        runContext();
//        runContainer();
    }

    public static void runContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
//        context.addBeanFactoryPostProcessor(new IndexBeanFactoryPostProcessor());
        context.refresh();
//        context.scan("com.zhoujjtech");
//        Object bean = context.getBean("indexFactoryBean");
//        System.out.println(bean.toString());
//        System.out.println(context.getBean(IndexService.class));
/*        IndexComsumer comsumer = context.getBean(IndexComsumer.class);
        comsumer.sayHello();*/
        context.start();
    }

    public static void runContainer() {
        Tomcat tomcat = new Tomcat();
        try {
            tomcat.setPort(8088);
            tomcat.addWebapp("/", "/Users/zhoujiajun/Documents/static/");
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        } finally {
            tomcat.getServer().await();
        }
    }
}
