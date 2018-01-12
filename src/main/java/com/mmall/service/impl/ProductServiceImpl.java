package com.mmall.service.impl;

import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.dao.ProductMapper;
import com.mmall.pojo.Product;
import com.mmall.service.IProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iProductService")
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ServerResponse saveOrUpdateProduct(Product product) {
        if (product != null){
            //判断子图是否为空
            if (StringUtils.isNotBlank(product.getSubImages())){
                //获取子图列表
                String[] subImageArray = product.getSubImages().split(",");
                //如果子图大于1张，则把第一张设为主图
                if (subImageArray.length>0){
                    product.setMainImage(subImageArray[0]);
                }
            }

            //如果是更新，则一定会传入id
            if (product.getId() != null){
                //id不为空，更新产品信息
                int rowCount = productMapper.updateByPrimaryKey(product);
                if (rowCount>0){
                    return ServerResponse.createBySuccess("更新产品成功");
                }
                return ServerResponse.createBySuccess("更新产品失败");
            }else {
                //id为空，则增加产品
                int rowCount = productMapper.insert(product);
                if (rowCount>0){
                    return ServerResponse.createBySuccess("新增产品成功");
                }
                return ServerResponse.createBySuccess("新增产品失败");
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新产品的参数错误");

    }

    @Override
    public ServerResponse<String> setSaleStatus(Integer productId, Integer status) {
        //若商品id或状态为空，则传入的参数是错误的，使用ILLEGAL_ARGUMENT返回
        if (productId == null || status == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Product product = new Product();
        product.setId(productId);
        product.setStatus(status);
        int rowCount = productMapper.updateByPrimaryKeySelective(product);
        if (rowCount>0){
            return ServerResponse.createBySuccess("修改产品销售状态成功");
        }
        return ServerResponse.createByErrorMessage("修改产品销售状态失败");
    }
}
