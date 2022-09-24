package cc.ccoder.designpatterns.strategy.simple;

import java.math.BigDecimal;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 14:52
 */
//固定值+百分比计费
public class FixedAndPercentagePricingStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculate(BigDecimal amount) {
        return new BigDecimal("1.00").add(amount.multiply(new BigDecimal("0.02")));
    }
}
