package cc.ccoder.designpatterns.strategy.factoryimpl.paymethod;

import cc.ccoder.designpatterns.strategy.factoryimpl.FundService;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 16:15
 */
public class WeChatFundService implements FundService {
    @Override
    public String pay(String params) {
        // Your business logic
        return getServiceCode() + "paying";
    }


    @Override
    public String getServiceCode() {
        return ThirdPayChannel.WECHAT.name();
    }
}
