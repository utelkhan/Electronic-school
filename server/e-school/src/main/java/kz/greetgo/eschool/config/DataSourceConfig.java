package kz.greetgo.eschool.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "kz.greetgo.eschool")
@PropertySource(value = {"classpath:application.properties"})
@EnableTransactionManagement
@MapperScan("kz.greetgo.eschool.repository")
public class DataSourceConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


    @Value("${spring.datasource.initialize}")
    private boolean initialize;
    @Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource){
        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setEnabled(initialize);
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    @Value("${spring.sql.init.schema-locations}")
    Resource schema;
    @Value("${spring.sql.init.data-locations}")
    Resource data;
    @Bean
    public DatabasePopulator databasePopulator(){
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(schema);
        populator.addScript(data);
        return populator;
    }

}
