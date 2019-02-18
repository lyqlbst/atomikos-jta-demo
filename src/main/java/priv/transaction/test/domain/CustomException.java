package priv.transaction.test.domain;

/**
 * @author yuqiang lin
 * @description 自定义异常
 * @email 1098387108@qq.com
 * @date 2019/1/26 4:08 PM
 */
public final class CustomException extends RuntimeException{
    public CustomException(String msg){
        super(msg);
    }
}
