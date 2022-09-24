package cc.ccoder.designpatterns.strategy.refactor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: congcong
 * @email: congccoder@gmail.com
 * @date: 2022/9/24 15:15
 */

public class PricingStrategyFactory {
    private static final Logger log = LoggerFactory.getLogger(PricingStrategyFactory.class);

    public PricingStrategyFactory(List<PricingStrategy> list) {
        init(list);
    }

    private final Map<String, PricingStrategy> pricingStrategyMap = new HashMap<>();

    private void init(List<PricingStrategy> strategyList) {
        if (strategyList == null) {
            return;
        }
        for (PricingStrategy strategy : strategyList) {
            String serviceCode = strategy.getServiceCode();
            if (serviceCode == null) {
                throw new IllegalArgumentException(String.format("Registration service code cannot be empty:%s",
                        strategy.getClass()));
            }
            if (!pricingStrategyMap.containsKey(serviceCode)) {
                pricingStrategyMap.put(serviceCode, strategy);
                log.info("Registration service: {} , {}", serviceCode, strategy.getClass());
            } else {
                throw new IllegalArgumentException(String.format("Duplicate registration service: %s , %s , %s",
                        serviceCode, pricingStrategyMap.get(serviceCode).getClass(), strategy.getClass()));
            }
        }
    }

    public PricingStrategy getService(String serviceCode) {
        return pricingStrategyMap.get(serviceCode);
    }
}
