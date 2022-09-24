package cc.ccoder.designpatterns.strategy.simple;

import java.math.BigDecimal;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 14:51
 */
public class Context {
    public Context() {
    }

    //上下文会维护指向某个策略对象的引用
    private PricingStrategy pricingStrategy;

    // 上下文通常通过构造方法来设置策略
    public Context(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    //也可以通过设置方法来切换策略
    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    // 上下文会将一些工作委派给策略对象，而不是自行实现不同版本的算法。
    public BigDecimal executeStrategy(BigDecimal amount) {
        return pricingStrategy.calculate(amount);
    }
}
