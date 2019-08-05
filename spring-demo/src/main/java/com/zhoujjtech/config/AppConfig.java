package com.zhoujjtech.config;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.mysql.jdbc.Driver;
import com.zhoujjtech.annotation.EnableDone;
import com.zhoujjtech.service.IndexService;
import com.zhoujjtech.service.OrderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.zhoujjtech")
//@MapperScan("com.zhoujjtech.dao")
//@EnableAspectJAutoProxy
//@EnableDone("com.zhoujjtech.dao")
//@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    private Log log = LogFactory.getLog(getClass());

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".html");
        registry.viewResolver(internalResourceViewResolver);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setConfiguration(configuration());
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean(initMethod = "initMethod")
    public IndexService indexService() {
        return new IndexService();
    }

//    @Bean
    public IndexService indexService1() {
        /**
         * 这个地方就是Full VS Lite 的区别之处, Full会进行动态代理, 对直接调用会进行相关特殊处理
         */
//        System.out.println("=====" + indexService().hashCode());
//        System.out.println("=====" + indexService().hashCode());
//        return new IndexServiceImpl1();
        return null;
    }
}
