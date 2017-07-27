package com.dmz;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * Created by 豆孟哲 on 2017/7/26.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication

//扫描接口
@MapperScan("com.dmz.dao")
public class Application  {
    private static Logger logger=Logger.getLogger(Application.class);

    //datasource配置
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return new DataSource();
    }
   //提供sqlSession
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.
                setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
      return sqlSessionFactoryBean.getObject();
    }
      //事务管理
    @Bean
    public PlatformTransactionManager transactionManager(){
        return  new DataSourceTransactionManager(dataSource());
    }



    //main入口函数
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}