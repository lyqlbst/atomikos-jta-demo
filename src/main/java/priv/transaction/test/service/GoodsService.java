package priv.transaction.test.service;

import priv.transaction.test.domain.User;

/**
 * @author yuqiang lin
 * @description 操作商品
 * @email 1098387108@qq.com
 * @date 2019/1/26 3:53 PM
 */
public interface GoodsService {
    /**
     * 购买商品并记录历史
     *
     * @param user   用户信息
     * @param goodId 商品id
     */
    void buy(User user, Integer goodId);
}
