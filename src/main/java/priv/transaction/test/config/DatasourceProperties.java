package priv.transaction.test.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author yuqiang lin
 * @description 数据库配置项
 * @email 1098387108@qq.com
 * @date 2019/2/18 5:54 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties
public class DatasourceProperties {
    private Map<String, Datasource> datasource;
}
