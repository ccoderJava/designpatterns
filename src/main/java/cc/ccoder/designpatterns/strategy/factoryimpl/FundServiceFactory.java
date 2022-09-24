package cc.ccoder.designpatterns.strategy.factoryimpl;

import cc.ccoder.designpatterns.strategy.factory.AbstractCodeServiceFactory;

import java.util.List;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 16:09
 */
public class FundServiceFactory extends AbstractCodeServiceFactory<FundService> {

    public FundServiceFactory(List<FundService> fundServiceList) {
        super(fundServiceList);
    }

    @Override
    protected String getFactoryName() {
        return "资金支付工厂";
    }
}
