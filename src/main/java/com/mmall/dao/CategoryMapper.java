package com.mmall.dao;

import com.mmall.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    /**
     * 通过父类id查询商品的子节点，返回商品列表
     * @param id
     * @return
     */
    List<Category> selectCategoryChildrenByParentId(Integer id);
}