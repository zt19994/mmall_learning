package com.mmall.service;

import com.mmall.common.ServerResponse;

public interface ICartService {

    /**
     * 添加到购物车
     * @param userId
     * @param productId
     * @param count 添加产品数量
     * @return
     */
    ServerResponse add(Integer userId, Integer productId, Integer count);
}
