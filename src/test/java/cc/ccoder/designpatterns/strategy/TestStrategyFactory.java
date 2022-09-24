package cc.ccoder.designpatterns.strategy;

import cc.ccoder.designpatterns.strategy.refactor.FixedPricingStrategy;
import cc.ccoder.designpatterns.strategy.refactor.PercentPricingStrategy;
import cc.ccoder.designpatterns.strategy.refactor.PricingStrategy;
import cc.ccoder.designpatterns.strategy.refactor.PricingStrategyFactory;
import cc.ccoder.designpatterns.strategy.refactor.StrategyEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 15:31
 */
public class TestStrategyFactory {

    private PricingStrategyFactory pricingStrategyFactory;

    @BeforeEach
    void init() {
        List<PricingStrategy> strategyList = initPricingStrategy();
        pricingStrategyFactory = new PricingStrategyFactory(strategyList);
    }


    @Test
    void testFixedCalculate() {
        PricingStrategy strategy = pricingStrategyFactory.getService(StrategyEnum.FIXED.name());
        BigDecimal fixedResult = strategy.calculate(new BigDecimal("100"));
        Assertions.assertEquals(fixedResult, new BigDecimal("1.00"));
    }

    @Test
    void testPercentCalculate() {
        PricingStrategy strategy = pricingStrategyFactory.getService(StrategyEnum.PERCENT.name());
        BigDecimal percentResult = strategy.calculate(new BigDecimal("100"));
        Assertions.assertEquals(percentResult, new BigDecimal("2.00"));
    }

    // 这里初始化所有PricingStrategy 接口的所有实现。
    // 如果你是通过spring管理，直接通过@Autowrited即可注入得到List<PricingStrategy>
    static List<PricingStrategy> initPricingStrategy() {
        return Arrays.asList(new FixedPricingStrategy(), new PercentPricingStrategy());
    }
}
