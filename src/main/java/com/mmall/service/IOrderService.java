package com.mmall.service;

import com.mmall.common.ServerResponse;

import java.util.Map;

public interface IOrderService {
    /**
     * 支付接口
     * @param orderNo
     * @param userId
     * @param path
     * @return
     */
    ServerResponse pay(Long orderNo, Integer userId, String path);

    /**
     *
     * @param params
     * @return
     */
    ServerResponse aliCallback(Map<String, String> params);

    /**
     * 通过用户id和订单号查询订单
     * @param userId
     * @param orderNo
     * @return
     */
    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);

}
