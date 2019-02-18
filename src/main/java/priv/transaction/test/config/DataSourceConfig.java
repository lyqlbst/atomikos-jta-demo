package priv.transaction.test.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.sql.XADataSource;

/**
 * @author yuqiang lin
 * @description 数据源配置
 * @email 1098387108@qq.com
 * @date 2019/1/26 2:26 PM
 */
@Configuration
public class DataSourceConfig {

    @Bean("goods")
    @ConfigurationProperties(prefix = "datasource.goods")
    public XADataSource goodsXADataSource() {
        return new MysqlXADataSource();
    }

    @Bean("history")
    @ConfigurationProperties(prefix = "datasource.history")
    public XADataSource historyXADataSource() {
        return new MysqlXADataSource();
    }

    @Bean(value = "goodsDataSource")
    public DataSource goodsAtomicDataSource() {
        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setXaDataSource(goodsXADataSource());
        dataSource.setUniqueResourceName("goods");
        dataSource.setMaxPoolSize(2);
        return dataSource;
    }

    @Bean("historyDataSource")
    public DataSource historyAtomicDataSource() {
        AtomikosDataSourceBean dataSource = new AtomikosDataSourceBean();
        dataSource.setXaDataSource(historyXADataSource());
        dataSource.setUniqueResourceName("history");
        dataSource.setPoolSize(2);
        return dataSource;
    }
}
