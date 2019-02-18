package priv.transaction.test.repository.goods;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.transaction.test.domain.goods.Goods;

/**
 * @author yuqiang lin
 * @description 物品repository
 * @email 1098387108@qq.com
 * @date 2019/1/26 3:51 PM
 */
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
    Goods findGoodsById(Integer goodId);
}
