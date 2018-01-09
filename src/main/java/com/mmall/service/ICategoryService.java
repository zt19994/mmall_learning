package com.mmall.service;

import com.mmall.common.ServerResponse;

public interface ICategoryService {
    /**
     * 添加商品类型
     * @param categoryName
     * @param parentId
     * @return
     */
    ServerResponse addCategory(String categoryName, Integer parentId);

    /**
     * 更新商品类型名称
     * @param categoryId
     * @param categoryName
     * @return
     */
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
}
