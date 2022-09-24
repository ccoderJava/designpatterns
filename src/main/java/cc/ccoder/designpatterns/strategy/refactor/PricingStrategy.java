package cc.ccoder.designpatterns.strategy.refactor;

import java.math.BigDecimal;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 14:52
 */
public interface PricingStrategy {
    BigDecimal calculate(BigDecimal amount);

    String getServiceCode();
}
