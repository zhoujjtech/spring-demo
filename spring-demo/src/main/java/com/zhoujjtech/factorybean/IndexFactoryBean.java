package com.zhoujjtech.factorybean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//@Component
public class IndexFactoryBean implements FactoryBean, InitializingBean {

    private Log log = LogFactory.getLog(getClass());

    private Class clazz;

    public IndexFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    public IndexFactoryBean() {

    }

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy invoke ...");
                return null;
            }
        });
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet..");
    }
}
