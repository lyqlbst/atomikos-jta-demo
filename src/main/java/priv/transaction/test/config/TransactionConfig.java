package priv.transaction.test.config;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class TransactionConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }

    @Bean(name = "userTransaction")
    public UserTransaction userTransaction() throws SystemException {
        UserTransaction userTransaction = new UserTransactionImp();
        userTransaction.setTransactionTimeout(10000);
        return userTransaction;
    }

    @Bean(name = "atomikosTransactionManager")
    public TransactionManager atomikosTransactionManager() {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        return userTransactionManager;
    }

    @Bean(name = "transactionManager")
    @DependsOn({"userTransaction", "atomikosTransactionManager"})
    public PlatformTransactionManager transactionManager() throws SystemException {
        UserTransaction userTransaction = userTransaction();
        TransactionManager atomikosTransactionManager = atomikosTransactionManager();
        AtomikosJtaPlatform.userTransaction = userTransaction;
        AtomikosJtaPlatform.transactionManager = atomikosTransactionManager;
        return new JtaTransactionManager(userTransaction, atomikosTransactionManager);
    }

}