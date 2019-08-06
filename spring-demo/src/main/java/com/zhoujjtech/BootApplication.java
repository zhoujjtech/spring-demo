package com.zhoujjtech;

import com.zhoujjtech.config.AppConfig;
import com.zhoujjtech.dao.IndexDaoMapper;
import com.zhoujjtech.dubbo.consumer.IndexComsumer;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;

public class BootApplication {

    public static void main(String[] args) {
        runContext();
//        runContainer();
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
        context.start();
    }

    public static void runContainer() {
        Tomcat tomcat = new Tomcat();
        try {
            tomcat.setPort(8088);
//            tomcat.addWebapp("/", "/Users/zhoujiajun/Documents/static/");

            // TODO: 2019-08-05 告诉源码所在的位置, 静态资源位置不起作用
            String sourcePath = BootApplication.class.getResource("/").getPath();
            Context ctx = tomcat.addWebapp("/", "/");
            WebResourceRoot resources = new StandardRoot(ctx);
            resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                    sourcePath, "/"));
            ctx.setResources(resources);
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        } finally {
            tomcat.getServer().await();
        }
    }
}
