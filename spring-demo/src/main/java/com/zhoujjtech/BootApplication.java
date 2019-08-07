package com.zhoujjtech;

import com.zhoujjtech.config.AppConfig;
import com.zhoujjtech.dao.IndexDaoMapper;
import com.zhoujjtech.dubbo.consumer.IndexComsumer;
import com.zhoujjtech.event.ContextRefreshListener;
import com.zhoujjtech.event.SendEmailEvent;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.Wrapper;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

public class BootApplication {

    public static void main(String[] args) {
//        runContext();
        runContainer();
        ///Users/zhoujiajun/Documents/spring-demo/spring-demo/out/production/classes/
//        System.out.println(BootApplication.class.getResource("/").getPath() );
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
//        context.publishEvent(new SendEmailEvent(context));
//        context.start();
//        context.addApplicationListener(new ContextRefreshListener());
    }

    public static void runContainer() {
        Tomcat tomcat = new Tomcat();
        try {
            // TODO: 2019-08-07 spring ioc的环境
            AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
            context.register(AppConfig.class);
            context.refresh();

            tomcat.setPort(8088);
            // TODO: 2019-08-05 告诉源码所在的位置, 静态资源位置不起作用
            String sourcePath = BootApplication.class.getResource("/").getPath();

            // TODO: 2019-08-07 告诉tomcat该项目是web项目, docBase静态文件web目录
//            Context ctx = tomcat.addWebapp("/", "/");
            // TODO: 2019-08-07 tomcat不会去识别为web项目, 没法去初始化springweb环境
            Context ct = tomcat.addContext("/", "/");


            // TODO: 2019-08-07 mvc request --> spring servlet --> 方法调用(反射) --> controller


            // TODO: 2019-08-07 spring web环境
            DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
            // TODO: 2019-08-07 调用Servlet的init方法
            tomcat.addServlet(ct, "mvc", dispatcherServlet).setLoadOnStartup(0);
            ct.addServletMapping("/*", "mvc");
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        } finally {
            tomcat.getServer().await();
        }
    }
}
