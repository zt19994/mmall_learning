package com.mmall.dao;

import com.mmall.pojo.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    /**
     * 通过用户id和shippingId删除地址，防止横向越权
     * @param userId
     * @param shippingId
     * @return
     */
    int deleteByShippingIdUserId(@Param("userId")Integer userId, @Param("shippingId")Integer shippingId);

    /**
     * 更新地址
     * @param shipping
     * @return
     */
    int updateByShipping(Shipping shipping);

    /**
     * 通过用户id和shippingId查询地址
     * @param userId
     * @param shippingId
     * @return
     */
    Shipping selectByShippingIdUserId(@Param("userId")Integer userId, @Param("shippingId")Integer shippingId);

    /**
     * 通过用户id查询地址列表
     * @param userId
     * @return
     */
    List<Shipping> selectByUserId(Integer userId);
}