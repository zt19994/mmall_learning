package com.mmall.vo;

import java.math.BigDecimal;

/**
 * 结合了产品和购物车的抽象对象
 */
public class CartProductVo {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer quantity;  //购物车中此商品的数量
    private String productName;
    private String productSubtitle;
    private String productMainImage;
    private BigDecimal productPrice;
    private Integer productStatus;
    private BigDecimal productTotalPrice;
    private Integer productStock;
    private Integer productChecked; //此商品是否勾选

    private String limitQuantity; //限制数量的一个返回结果



}
