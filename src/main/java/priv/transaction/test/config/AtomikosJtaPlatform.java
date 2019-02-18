package priv.transaction.test.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

/**
 * @author yuqiang lin
 * @description AtomikosJtaPlatform
 * @email 1098387108@qq.com
 * @date 2019/1/26 6:34 PM
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AtomikosJtaPlatform extends AbstractJtaPlatform {
    private static final long serialVersionUID = 1L;
    static transient TransactionManager transactionManager;
    static transient UserTransaction userTransaction;

    @Override
    protected TransactionManager locateTransactionManager() {
        return transactionManager;
    }

    @Override
    protected UserTransaction locateUserTransaction() {
        return userTransaction;
    }
}
