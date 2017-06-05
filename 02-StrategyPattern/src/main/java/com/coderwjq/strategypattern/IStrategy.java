package com.coderwjq.strategypattern;

/**
 * @Created by coderwjq on 2017/6/5 9:37.
 * @Desc
 */

public interface IStrategy {
    /**
     * 根据不同的优惠策略，返回不同的优惠价格
     *
     * @param salePrice
     * @return
     */
    double discountPrice(double salePrice);
}
