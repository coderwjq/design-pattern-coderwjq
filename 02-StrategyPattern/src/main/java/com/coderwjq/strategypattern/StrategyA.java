package com.coderwjq.strategypattern;

/**
 * @Created by coderwjq on 2017/6/5 9:39.
 * @Desc 满200减100
 */

public class StrategyA implements IStrategy {
    @Override
    public double discountPrice(double salePrice) {
        if (salePrice >= 200) {
            return salePrice - 100;
        } else {
            return salePrice;
        }
    }
}
