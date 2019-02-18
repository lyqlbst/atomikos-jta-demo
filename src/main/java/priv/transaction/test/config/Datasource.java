package priv.transaction.test.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuqiang lin
 * @description 数据库信息
 * @email 1098387108@qq.com
 * @date 2019/2/18 5:56 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Datasource {
    private String url;
    private String user;
    private String password;
    private Integer minimumIdle;
    private Integer maximumPoolSize;
}
