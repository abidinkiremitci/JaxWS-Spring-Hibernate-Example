package beardthered.db.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:persistence-jndi.properties")
@EnableJpaRepositories(basePackages = "beardthered.db.dao")
public class PersistenceJNDIConfig {

    @Autowired
    Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("beardthered.db.model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public DataSource dataSource() throws NamingException {
        return (DataSource) new JndiTemplate().lookup(env.getProperty("jndi.name"));
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("javax.persistence.sharedCache.mode",env.getProperty("javax.persistence.sharedCache.mode"));
        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache",env.getProperty("hibernate.cache.use_second_level_cache"));
        hibernateProperties.setProperty("hibernate.cache.region.factory_class",env.getProperty("hibernate.cache.region.factory_class"));
        hibernateProperties.setProperty("hibernate.ejb.naming_strategy",env.getProperty("hibernate.ejb.naming_strategy"));
        hibernateProperties.setProperty("hibernate.show_sql",env.getProperty("hibernate.show_sql"));
        hibernateProperties.setProperty("hibernate.format_sql",env.getProperty("hibernate.format_sql"));
        hibernateProperties.setProperty("hibernate.transaction.flush_before_completion",env.getProperty("hibernate.transaction.flush_before_completion"));
        hibernateProperties.setProperty("hibernate.connection.release_mode",env.getProperty("hibernate.connection.release_mode"));
        hibernateProperties.setProperty("hibernate.connection.autocommit",env.getProperty("hibernate.connection.autocommit"));
        hibernateProperties.setProperty("hibernate.generate_statistics",env.getProperty("hibernate.generate_statistics"));
        hibernateProperties.setProperty("hibernate.max_fetch_depth",env.getProperty("hibernate.max_fetch_depth"));
        hibernateProperties.setProperty("hibernate.default_batch_fetch_size",env.getProperty("hibernate.default_batch_fetch_size"));
        hibernateProperties.setProperty("hibernate.batch_fetch_style",env.getProperty("hibernate.batch_fetch_style"));
        hibernateProperties.setProperty("hibernate.order_updates",env.getProperty("hibernate.order_updates"));
        hibernateProperties.setProperty("hibernate.use_sql_comments",env.getProperty("hibernate.use_sql_comments"));
        hibernateProperties.setProperty("hibernate.transaction.manager_lookup_class",env.getProperty("hibernate.transaction.manager_lookup_class"));
        return hibernateProperties;
    }
}