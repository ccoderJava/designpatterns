package cc.ccoder.designpatterns.strategy.simple;

import java.math.BigDecimal;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 14:52
 */
//固定百分比计费
public class PercentPricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculate(BigDecimal amount) {
        if (amount == null) {
            return BigDecimal.ZERO;
        }
        return amount.multiply(new BigDecimal("0.02"));
    }
}
