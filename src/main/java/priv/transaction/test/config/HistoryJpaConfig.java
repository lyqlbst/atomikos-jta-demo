package priv.transaction.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * @author yuqiang lin
 * @description JPA配置
 * @email 1098387108@qq.com
 * @date 2019/1/26 3:02 PM
 */
@Configuration
@EnableJpaRepositories(value = "priv.transaction.test.repository.history"
        , entityManagerFactoryRef = "historyTransactionManger")
public class HistoryJpaConfig {
    private final JpaVendorAdapter jpaVendorAdapter;
    private final JpaProperties jpaProperties;

    @Autowired
    public HistoryJpaConfig(JpaVendorAdapter jpaVendorAdapter
            , JpaProperties jpaProperties) {
        this.jpaVendorAdapter = jpaVendorAdapter;
        this.jpaProperties = jpaProperties;
    }

    @DependsOn("transactionManager")
    @Bean("historyTransactionManger")
    public LocalContainerEntityManagerFactoryBean transactionManager(@Qualifier("historyDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(dataSource);
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setPackagesToScan("priv.transaction.test.domain.history");
        entityManager.setPersistenceUnitName("historyPersistenceUnit");
        entityManager.setJpaPropertyMap(jpaProperties.getProperties());
        return entityManager;
    }
}
