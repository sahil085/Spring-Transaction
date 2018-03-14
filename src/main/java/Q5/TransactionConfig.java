package Q5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "Q5")
public class TransactionConfig {

    @Bean
    JdbcTemplate jdbcTemplate(){
JdbcTemplate jdbcTemplate=new JdbcTemplate();
jdbcTemplate.setDataSource(dataSource());
return jdbcTemplate;
    }

    @Bean
    DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/transactionDemo");
        dataSource.setUsername("root");
        dataSource.setPassword("ankit_mysql");
        return dataSource;
    }

    @Bean
    PlatformTransactionManager transactionManager(){
        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
}
