package priv.transaction.test.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import priv.transaction.test.domain.CustomException;
import priv.transaction.test.domain.goods.Goods;
import priv.transaction.test.domain.User;
import priv.transaction.test.repository.goods.GoodsRepository;
import priv.transaction.test.service.GoodsService;
import priv.transaction.test.service.HistoryService;

import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.*;

/**
 * @author yuqiang lin
 * @description GoodService实现类
 * @email 1098387108@qq.com
 * @date 2019/1/26 3:59 PM
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsServiceImpl.class);
    private final GoodsRepository goodsRepository;
    private final HistoryService historyService;

    @Autowired
    public GoodsServiceImpl(GoodsRepository goodsRepository
            , HistoryService historyService) {
        this.goodsRepository = goodsRepository;
        this.historyService = historyService;
    }

    @Transactional(value = REQUIRED, rollbackOn = Exception.class)
    @Modifying
    @Override
    public void buy(User user, Integer goodId) {
        Goods goods = goodsRepository.findGoodsById(goodId);
        goods.setGoodCount(goods.getGoodCount() - 1);
        // log the history
        try {
            historyService.recordHistory(user, goodId);
        } catch (Exception e) {
            LOGGER.error("error:", e);
        }
    }
}
