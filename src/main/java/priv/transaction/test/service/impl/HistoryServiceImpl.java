package priv.transaction.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.transaction.test.domain.history.BuyHistory;
import priv.transaction.test.domain.CustomException;
import priv.transaction.test.domain.User;
import priv.transaction.test.repository.history.BuyHistoryRepository;
import priv.transaction.test.service.HistoryService;

import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.*;

/**
 * @author yuqiang lin
 * @description HistoryService实现类
 * @email 1098387108@qq.com
 * @date 2019/1/26 4:45 PM
 */
@Service
public class HistoryServiceImpl implements HistoryService {
    private final BuyHistoryRepository buyHistoryRepository;

    @Autowired
    public HistoryServiceImpl(BuyHistoryRepository buyHistoryRepository) {
        this.buyHistoryRepository = buyHistoryRepository;
    }

    @Transactional(value = REQUIRED, rollbackOn = Exception.class)
    @Override
    public void recordHistory(User user, Integer goodId) {
        BuyHistory buyHistory = new BuyHistory()
                .setGoodId(goodId)
                .setUserId(user.getUserId())
                .setUserName(user.getUserName());
        buyHistoryRepository.save(buyHistory);
//        throw new CustomException("测试事务");
    }
}
