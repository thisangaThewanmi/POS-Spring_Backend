package lk.ijse.config;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManagerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@ComponentScan(basePackages = "lk.ijse")
@EnableJpaRepositories(basePackages = "lk.ijse.dao")
//api JpaRepository eka use karanne dao ekedine so ekata acess denna oni
@EnableTransactionManagement
//Enables @Transactional: When you annotate a class or a method with @Transactional, Spring wraps it in a proxy that manages transactions for you. For example, it opens a transaction before entering the method, commits it on successful completion, or rolls it back if an exception occurs.
//enables Spring’s annotation-driven transaction management capability. It allows you to manage transactions declaratively using the @Transactional annotation.
public class WebAppRootConfig {

        @Bean
        public ModelMapper modelMapper() {

            return new ModelMapper();
        }

        @Bean
        //data source eka hadaganna
        public DataSource dataSource() {

          /*  EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
            return builder.setType(EmbeddedDatabaseType.HSQL).build();*/

            var dmds = new DriverManagerDataSource();
            dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");


            dmds.setUrl("jdbc:mysql://localhost:3306/SpringPosFinal?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true");
            dmds.setUsername("root");
            dmds.setPassword("Ijse@1234");
            return dmds;
        }

        @Bean
        //orm tool eka config kara gana
        //hibernate wlta adala configurations (properties file eke dana ewa meke dnna puluwn)
        //meka krla tiyenne JPA wlin mkda entityManagerFactory ne use krla tiyenne

        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            vendorAdapter.setGenerateDdl(true);

            LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
            //adala vendorwa select krnne metaning(hibernateda,eclipseda etc)
            factory.setJpaVendorAdapter(vendorAdapter);
            factory.setPackagesToScan("lk.ijse.entity.impl");
            factory.setDataSource(dataSource());
            return factory;
        }

        @Bean
        //Transaction handling
        public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

            JpaTransactionManager txManager = new JpaTransactionManager();
            txManager.setEntityManagerFactory(entityManagerFactory);
            return txManager;
        }

        @PreDestroy
        //meka one wene server eka connection close karaganna kilin stop unoth threa eka allow karannen aluthen connection ekak hadanna cause parana
        //conection eka nisa  eth eka nisa memory leak wei kila so thread eka close karala driver eka aye restart karanna ona
       public void cleanUp() {
        try {
            // Clean up the abandoned connection thread

            AbandonedConnectionCleanupThread.checkedShutdown();
            System.out.println("AbandonedConnectionCleanupThread shut down successfully.");


            // Deregister the MySQL JDBC driver to avoid memory leaks

            DriverManager.deregisterDriver(DriverManager.getDriver("jdbc:mysql://localhost:3306"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }




