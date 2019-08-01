package com.zhoujjtech.processor;

import com.zhoujjtech.service.IndexService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


//@Component
public class IndexBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof IndexService) {
            Class<?>[] interfaces = bean.getClass().getInterfaces();
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), interfaces, new IndexInvocationHandler(bean));
        }
        return bean;
    }

    private class IndexInvocationHandler implements InvocationHandler {

        private Object bean;

        private IndexInvocationHandler(Object bean) {
            this.bean = bean;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before proxy invoke....");
            method.invoke(bean, args);
            System.out.println("after proxy invoke....");
            return bean;
        }
    }
}
