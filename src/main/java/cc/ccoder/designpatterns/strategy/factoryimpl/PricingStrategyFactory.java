package cc.ccoder.designpatterns.strategy.factoryimpl;

import cc.ccoder.designpatterns.strategy.factory.AbstractCodeServiceFactory;

import java.util.List;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 16:09
 */
public class PricingStrategyFactory extends AbstractCodeServiceFactory<PricingStrategy> {

    public PricingStrategyFactory(List<PricingStrategy> pricingStrategies) {
        super(pricingStrategies);
    }

    @Override
    protected String getFactoryName() {
        return "计费策略工厂";
    }
}
