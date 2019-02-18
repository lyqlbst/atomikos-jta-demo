package priv.transaction.test.domain.history;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import priv.transaction.test.domain.User;

import javax.persistence.*;

/**
 * @author yuqiang lin
 * @description 购买历史
 * @email 1098387108@qq.com
 * @date 2019/1/26 3:56 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "buy_history")
public class BuyHistory {
    /**
     * 历史id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;
    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 商品id
     */
    @Column(name = "good_id")
    private Integer goodId;
}
