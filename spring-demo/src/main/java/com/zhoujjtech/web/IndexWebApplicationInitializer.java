package com.zhoujjtech.web;

import com.zhoujjtech.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

// TODO: 2019-08-07 Servlet3.0的规范
public class IndexWebApplicationInitializer implements ServletContainerInitializer  {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic registration = servletContext.addServlet("index", new IndexServlet());
        // TODO: 2019-08-07 匹配全路径, 优先级高
        registration.addMapping("/*");
    }
}
