package com.zhoujjtech.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Random;


@Configuration
//@EnableDubboConfig
@DubboComponentScan(basePackages = "com.zhoujjtech.dubbo")
@PropertySource("classpath:/application.properties")
public class DubboConfig {

    @Value("${dubbo.registry.address}")
    private String registryAddress;

    @Value("${server.port}")
    private Integer serverPort;

    @Value("${dubbo.application.name}")
    private String applicationName;

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(applicationName);
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(registryAddress);
        registryConfig.setProtocol("zookeeper");
        registryConfig.setFile(System.getProperty("user.home") + "/.dubbo/" + serverPort + "-asscenter-inst.cache");
        return registryConfig;
    }
    
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(serverPort + 10000);
        return protocolConfig;
    }
}
