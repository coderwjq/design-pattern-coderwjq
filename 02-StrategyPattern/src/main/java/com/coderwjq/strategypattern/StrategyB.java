package com.coderwjq.strategypattern;

/**
 * @Created by coderwjq on 2017/6/5 9:39.
 * @Desc 总价打6折
 */

public class StrategyB implements IStrategy {
    @Override
    public double discountPrice(double salePrice) {
        return salePrice * 0.6;
    }
}
