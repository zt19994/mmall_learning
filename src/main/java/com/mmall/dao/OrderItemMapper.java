package com.mmall.dao;

import com.mmall.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    /**
     * 获取订单列表，通过orderNo和userId
     * @param orderNo
     * @param userId
     * @return
     */
    List<OrderItem> getByOrderNoUserId(@Param("orderNo")Long orderNo, @Param("userId")Integer userId);

    /**
     * 批量插入
     * @param orderItemList
     */
    void batchInsert(@Param("orderItemList") List<OrderItem> orderItemList);
}