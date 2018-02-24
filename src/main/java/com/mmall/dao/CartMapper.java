package com.mmall.dao;

import com.mmall.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    /**
     * 通过用户id和产品id查询购物车
     *
     * @param userId
     * @param productId
     * @return
     */
    Cart selectCartByUserIdProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);

    /**
     * 通过用户id查询购物车列表
     *
     * @param userId
     * @return
     */
    List<Cart> selectCartByUserId(Integer userId);

    /**
     * 查询购物车，检查是否勾选
     *
     * @param userId
     * @return
     */
    int selectCartProductCheckedStatusByUserId(Integer userId);

    /***
     * 通过用户id和产品列表来删除产品
     * @param userId
     * @param productList
     * @return
     */
    int deleteByUserIdProductIds(@Param("userId") Integer userId, @Param("productList") List<String> productList);

    /**
     * 更新产品是否被选择
     *
     * @param userId
     * @param checked
     * @return
     */
    int checkedOrUncheckedProduct(@Param("userId") Integer userId, @Param("checked") Integer checked, @Param("productId") Integer productId);

    /**
     * 通过用户id查询购物车中产品的总数
     *
     * @param userId
     * @return
     */
    int selectCartProductCount(Integer userId);

    /**
     * 通过用户id查询购物车中勾选的商品
     * @param userId
     * @return
     */
    List<Cart> selectCheckedCartByUserId(Integer userId);
}