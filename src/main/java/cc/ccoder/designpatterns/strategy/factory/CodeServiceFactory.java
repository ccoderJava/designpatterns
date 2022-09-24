package cc.ccoder.designpatterns.strategy.factory;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 14:52
 */
public interface CodeServiceFactory<Provider extends CodeService> {

    /**
     * 获取服务
     *
     * @param serviceCode 服务编码
     * @return 返回服务，不存在时返回null
     */
    Provider getService(String serviceCode);
}
