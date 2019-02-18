package priv.transaction.test.service;

import priv.transaction.test.domain.User;

/**
 * @author yuqiang lin
 * @description 历史信息Service
 * @email 1098387108@qq.com
 * @date 2019/1/26 4:44 PM
 */
public interface HistoryService {
    /**
     * 记录历史
     *
     * @param user   用户信息
     * @param goodId 商品id
     */
    void recordHistory(User user, Integer goodId);
}
