package com.zhoujjtech.processor;

import com.zhoujjtech.service.OrderService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

//@Component
public class IndexBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("indexService");
//        beanDefinition.setScope("prototype");
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(new OrderService());
    }
}
