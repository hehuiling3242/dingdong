package com.dingdong.config;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Springbean配置 类似于过去spring的application.xml
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {  //mybatis mapper 所在package
        "com.dingdong.mapper"
})
public class BaseServiceSpringBeansConfig implements TransactionManagementConfigurer {

    private static final String TYPE_ALIASES_PACKAGE =
            "com.dingdong.domain.query," +
                    "com.dingdong.domain.model";

    /**
     * 数据源
     */
    @Autowired
    private DataSource dataSource;

    /**
     * 事务
     */
    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        return this.getSqlSessionFactory(dataSource, TYPE_ALIASES_PACKAGE, "classpath*:mapper/*Mapper.xml");
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    private static SqlSessionFactory getSqlSessionFactory(
            DataSource dataSource,
            String typeAliasesPackage,
            String... mapperLocations

    ) {
        Assert.hasText(typeAliasesPackage, "typeAliasesPackage is not empty");
        Assert.notNull(dataSource, "dataSource is not null");
        Assert.notEmpty(mapperLocations, "mapperLocations can not empty");

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage(typeAliasesPackage);
        bean.setVfs(SpringBootVFS.class);

        Properties properties = new Properties();
        //properties.put("Oracle", "oracle");
        properties.put("MySQL", "mysql");
        VendorDatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        databaseIdProvider.setProperties(properties);

        bean.setDatabaseIdProvider(databaseIdProvider);


        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        List<Resource> resources = new ArrayList<Resource>();
        List<String> mappersName = new ArrayList<String>();
        try {
            for (String e : mapperLocations) {
                Resource[] ss = resolver.getResources(e);
                for (Resource o : ss) {
                    mappersName.add(o.getFilename());
                    resources.add(o);
                }
            }
            bean.setMapperLocations(resources.toArray(new Resource[]{}));
            bean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
            return bean.getObject();
        } catch (Exception e) {
            throw new IllegalStateException("SqlSessionFactory init fail," + e.getMessage(), e);
        }
    }
}
