package com.example.demo.coco;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 数据源配置类
 */
@Configuration
@MapperScan(basePackages = DataSourceConfig.BASEPACKAGE, sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {
    //扫描mapper文件
    static final String MAPPER_LOCATION = "mappers/*.xml";
    //扫描dao接口
    static final String BASEPACKAGE = "com.example.demo.student.dao";

    @Value("${db.datasource.username}")
    private String username;
    @Value("${db.datasource.url}")
    private String url;
    @Value("${db.datasource.pwd}")
    private String pwd;

    @Bean(name = "mysqlDataSource")
    public DataSource getDataSource(){
        //配置德鲁伊数据源
        DruidDataSource d = new DruidDataSource();
        d.setUsername(username);
        d.setPassword(pwd);
        d.setUrl(url);

        d.setMaxActive(10);
        d.setInitialSize(5);
        d.setMaxWait(6000);
        d.setMinIdle(5);

        return d;
    }

    /*开启事务*/
    @Bean
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }

    /*mybatis*/
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
