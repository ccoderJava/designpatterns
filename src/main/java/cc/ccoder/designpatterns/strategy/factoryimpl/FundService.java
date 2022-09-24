package cc.ccoder.designpatterns.strategy.factoryimpl;

import cc.ccoder.designpatterns.strategy.factory.CodeService;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 16:13
 */
public interface FundService extends CodeService {

    String pay(String params);
}
