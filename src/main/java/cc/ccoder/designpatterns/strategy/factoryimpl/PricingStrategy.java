package cc.ccoder.designpatterns.strategy.factoryimpl;

import cc.ccoder.designpatterns.strategy.factory.CodeService;

import java.math.BigDecimal;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 16:10
 */
public interface PricingStrategy extends CodeService {

    BigDecimal calculate(BigDecimal amount);
}
