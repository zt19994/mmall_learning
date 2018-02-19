package com.mmall.service;

import com.mmall.common.ServerResponse;

public interface IOrderService {
    /**
     * 支付接口
     * @param orderNo
     * @param userId
     * @param path
     * @return
     */
    ServerResponse pay(Long orderNo, Integer userId, String path);
}
