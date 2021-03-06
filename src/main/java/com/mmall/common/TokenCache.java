package com.mmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 本地缓存
 * 1.用与检查密码提示问题是否正确
 */
public class TokenCache {

    //1.日志
    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    //忘记密码的token前缀
    public static final String TOKEN_PREFIX = "token_";

    //2.声明静态的内存块,LRU算法
    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000)
            .expireAfterAccess(12, TimeUnit.HOURS).build(new CacheLoader<String, String>() {
                //默认的数据加载实现，当调用get取值的时候，如果key没有对应的取值，就调用这个方法进行加载。
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });

    public static void setKey(String key, String value){
        localCache.put(key, value);
    }

    public static String getKey(String key){
        String value = null;
        try {
            value =localCache.get(key);
            if("null".equals(value)){
                return null;
            }
            return value;
        }catch (Exception e){
            logger.error("localCache get error", e);
        }
        return null;
    }
}
