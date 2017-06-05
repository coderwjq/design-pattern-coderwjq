package com.coderwjq.strategypattern;

/**
 * @Created by coderwjq on 2017/6/5 9:40.
 * @Desc
 */

public class StrategyContext {
    private IStrategy mStrategy;

    public void setStrategy(IStrategy strategy) {
        mStrategy = strategy;
    }

    public double getDiscountPrice(double salePrice) {
        if (mStrategy != null) {
            return mStrategy.discountPrice(salePrice);
        } else {
            throw new RuntimeException("未设置优惠策略");
        }
    }
}
