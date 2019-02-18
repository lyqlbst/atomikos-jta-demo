package priv.transaction.test.repository.history;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.transaction.test.domain.history.BuyHistory;

/**
 * @author yuqiang lin
 * @description
 * @email 1098387108@qq.com
 * @date 2019/1/26 4:01 PM
 */
public interface BuyHistoryRepository extends JpaRepository<BuyHistory,Integer> {
}
