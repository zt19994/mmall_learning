package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

public interface ICartService {

    /**
     * 添加到购物车
     *
     * @param userId
     * @param productId
     * @param count     添加产品数量
     * @return
     */
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    /**
     * 更新购物车
     *
     * @param userId
     * @param productId
     * @param count
     * @return
     */
    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    /**
     * 删除产品
     *
     * @param userId
     * @param productIds
     * @return
     */
    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    /**
     * 通过用户id查询购物车
     *
     * @param userId
     * @return
     */
    ServerResponse<CartVo> list(Integer userId);

    /**
     * 通过用户id查询所有购物车产品，正序或反序,或单选
     *
     * @param userId
     * @param checked
     * @param productId
     * @return
     */
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer checked, Integer productId);

    /**
     * 通过用户id查询购物车中产品总数
     *
     * @param userId
     * @return
     */
    ServerResponse<Integer> getCartProductCount(Integer userId);
}
