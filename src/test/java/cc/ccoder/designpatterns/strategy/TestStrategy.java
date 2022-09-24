package cc.ccoder.designpatterns.strategy;

import cc.ccoder.designpatterns.strategy.simple.Context;
import cc.ccoder.designpatterns.strategy.simple.FixedAndPercentagePricingStrategy;
import cc.ccoder.designpatterns.strategy.simple.FixedPricingStrategy;
import cc.ccoder.designpatterns.strategy.simple.PercentPricingStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 14:53
 */
public class TestStrategy {
    @Test
    void testConstructorCreation() {
        //构造器方式指定策略
        Context context = new Context(new FixedPricingStrategy());
        BigDecimal fixedResult = context.executeStrategy(new BigDecimal("100"));
        Assertions.assertEquals(fixedResult, new BigDecimal("1.00"));

        //切换策略
        context.setPricingStrategy(new PercentPricingStrategy());
        BigDecimal percentResult = context.executeStrategy(new BigDecimal("100"));
        Assertions.assertEquals(percentResult, new BigDecimal("2.00"));
    }

    @Test
    void testSetMethodCreation() {
        //set设置方法设置策略和切换
        Context context = new Context();

        //设置固定计费策略
        context.setPricingStrategy(new FixedPricingStrategy());
        BigDecimal fixedResult = context.executeStrategy(new BigDecimal("100"));
        Assertions.assertEquals(fixedResult, new BigDecimal("1.00"));

        //设置百分比计费策略
        context.setPricingStrategy(new PercentPricingStrategy());
        BigDecimal percentResult = context.executeStrategy(new BigDecimal("100"));
        Assertions.assertEquals(percentResult, new BigDecimal("2.00"));

        //设置固定值+百分比计费策略
        context.setPricingStrategy(new FixedAndPercentagePricingStrategy());
        BigDecimal fixedAndPercentResult = context.executeStrategy(new BigDecimal("100"));
        Assertions.assertEquals(fixedAndPercentResult, new BigDecimal("3.00"));
    }


    @ParameterizedTest
    @MethodSource(value = "allStrategy")
    void testRouteStrategy(String strategy) {
        Context context = new Context();
        if ("fixed".equals(strategy)) {
            context.setPricingStrategy(new FixedPricingStrategy());
        }
        if ("percent".equals(strategy)) {
            context.setPricingStrategy(new PercentPricingStrategy());
        }
        if ("fixedAndPercentage".equals(strategy)) {
            context.setPricingStrategy(new FixedAndPercentagePricingStrategy());
        }

        BigDecimal result = context.executeStrategy(new BigDecimal("100"));
        //打印结果
    }

    static Object[] allStrategy() {
        return new Object[]{"fixed", "percent", "fixedAndPercentage"};
    }
}
