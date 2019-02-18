package priv.transaction.test.domain.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @author yuqiang lin
 * @description 商品信息
 * @email 1098387108@qq.com
 * @date 2019/1/26 3:45 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "goods")
public class Goods {
    /**
     * 商品id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 物品名
     */
    @Column(name = "good_name")
    private String goodName;
    /**
     * 物品剩余数量
     */
    @Column(name = "good_count")
    private Integer goodCount;
}
