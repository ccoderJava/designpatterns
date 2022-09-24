package cc.ccoder.designpatterns.strategy.simple;

import java.math.BigDecimal;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 14:52
 */
//固定计费模式
public class FixedPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculate(BigDecimal amount) {
        return new BigDecimal("1.00");
    }
}
