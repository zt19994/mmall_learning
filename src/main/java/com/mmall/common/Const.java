package com.mmall.common;

import com.google.common.collect.Sets;

import java.util.Set;

public class Const {

    //正确的用户常量
    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    //产品排序
    public interface ProductListOrderBy{
        //降序和升序
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
    }

    //设置角色常量
    public interface Role{
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1; //管理员用户
    }

    //产品状态枚举类
    public enum ProductStatusEnum{
        ON_SALE(1, "在线");

        private String value;
        private int code;

        ProductStatusEnum( int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }
}
