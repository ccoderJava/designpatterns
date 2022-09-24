package cc.ccoder.designpatterns.strategy.factory;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 14:52
 */
public interface CodeService {

    /**
     * 服务编码必须唯一
     *
     * @return 服务编码
     */
    String getServiceCode();
}
