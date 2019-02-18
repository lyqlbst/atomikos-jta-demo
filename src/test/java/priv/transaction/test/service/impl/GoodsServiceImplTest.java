package priv.transaction.test.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import priv.transaction.test.TestApplicationTests;
import priv.transaction.test.domain.User;
import priv.transaction.test.domain.goods.Goods;
import priv.transaction.test.repository.goods.GoodsRepository;
import priv.transaction.test.service.GoodsService;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yuqiang lin
 * @description
 * @email 1098387108@qq.com
 * @date 2019/1/26 4:13 PM
 */
public class GoodsServiceImplTest extends TestApplicationTests {
    @Autowired
    private GoodsService goodsService;

    private static final List<User> USERS = Stream.of(
            User.builder().userId(1).userName("张三").build()
            , User.builder().userId(2).userName("李四").build()
            , User.builder().userId(3).userName("王五").build()
            , User.builder().userId(4).userName("赵六").build())
            .collect(Collectors.toList());

    @Test
    public void buy() {
        User user = USERS.get(ThreadLocalRandom.current().nextInt(0, USERS.size()));
//        user.setUserName("超长超长超长超长超长超长超长超长超长超长超长");
        goodsService.buy(user, 1);
    }
}