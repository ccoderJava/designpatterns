package cc.ccoder.designpatterns.strategy;


import cc.ccoder.designpatterns.strategy.factoryimpl.FundService;
import cc.ccoder.designpatterns.strategy.factoryimpl.FundServiceFactory;
import cc.ccoder.designpatterns.strategy.factoryimpl.PricingStrategy;
import cc.ccoder.designpatterns.strategy.factoryimpl.PricingStrategyFactory;
import cc.ccoder.designpatterns.strategy.factoryimpl.paymethod.AliPayFundService;
import cc.ccoder.designpatterns.strategy.factoryimpl.paymethod.ThirdPayChannel;
import cc.ccoder.designpatterns.strategy.factoryimpl.paymethod.WeChatFundService;
import cc.ccoder.designpatterns.strategy.factoryimpl.pricing.FixedPricingStrategy;
import cc.ccoder.designpatterns.strategy.factoryimpl.pricing.PercentPricingStrategy;
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
 * @date: 2022/9/24 16:18
 */
public class TestAbstractStrategyFactory {


    private FundServiceFactory fundServiceFactory;

    private PricingStrategyFactory pricingStrategyFactory;

    @BeforeEach
    void init() {
        fundServiceFactory = new FundServiceFactory(initFundService());
        pricingStrategyFactory = new PricingStrategyFactory(initPricingStrategy());
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

    @Test
    void testFundServiceAlipay() {
        FundService service = fundServiceFactory.getService(ThirdPayChannel.ALIPAY.name());
        String result = service.pay("pay parameters");

        Assertions.assertTrue(result.startsWith(ThirdPayChannel.ALIPAY.name()));
    }

    @Test
    void testFundServiceWeChat() {
        FundService service = fundServiceFactory.getService(ThirdPayChannel.WECHAT.name());
        String result = service.pay("pay parameters");

        Assertions.assertTrue(result.startsWith(ThirdPayChannel.WECHAT.name()));
    }


    // 这里初始化所有PricingStrategy 接口的所有实现。
    // 如果你是通过spring管理，直接通过@Autowrited即可注入得到List<PricingStrategy>
    static List<PricingStrategy> initPricingStrategy() {
        return Arrays.asList(new FixedPricingStrategy(), new PercentPricingStrategy());
    }

    //如上所示
    static List<FundService> initFundService() {
        return Arrays.asList(new WeChatFundService(), new AliPayFundService());
    }
}
