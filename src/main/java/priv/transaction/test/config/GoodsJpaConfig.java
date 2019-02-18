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
@DependsOn("transactionManager")
@EnableJpaRepositories(value = "priv.transaction.test.repository.goods"
        , entityManagerFactoryRef = "goodsEntityManager")
public class GoodsJpaConfig {
    private final JpaVendorAdapter jpaVendorAdapter;
    private final JpaProperties jpaProperties;

    @Autowired
    public GoodsJpaConfig(JpaVendorAdapter jpaVendorAdapter
            , JpaProperties jpaProperties) {
        this.jpaVendorAdapter = jpaVendorAdapter;
        this.jpaProperties = jpaProperties;
    }

    @Bean("goodsEntityManager")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("goodsDataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(dataSource);
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setPackagesToScan("priv.transaction.test.domain.goods");
        entityManager.setPersistenceUnitName("goodsPersistenceUnit");
        entityManager.setJpaPropertyMap(jpaProperties.getProperties());
        return entityManager;
    }
}
