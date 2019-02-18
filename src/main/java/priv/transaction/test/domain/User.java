package priv.transaction.test.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author yuqiang lin
 * @description 用户信息
 * @email 1098387108@qq.com
 * @date 2019/1/26 3:53 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户姓名
     */
    private String userName;
}
