package com.boxflux.tool.web.config.cache;

import com.boxflux.tool.web.common.service.RedisService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wangguanglin on 2019/6/15.
 */
@Aspect
@Component
public class BoxCacheAspect {

    @Autowired
    private RedisService redisService;

    @Autowired
    private BloomFilter bloomFilter;

    private final static Logger logger = LoggerFactory.getLogger(BoxCacheAspect.class);

    @Pointcut("@annotation(com.boxflux.tool.web.config.cache.BoxCache)")
    public void cacheMethod() {
    }

    @Around("cacheMethod()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        String key = cacheKey(pjp);
        Object obj = null;
        Object cacheValue = getFromCache(key);
        if(null == cacheValue) {
            synchronized (this) {
                cacheValue = getFromCache(key);
                if(null == cacheValue) {
                    logger.debug("from db...");
                    obj = pjp.proceed();
                    if(null != obj) {
                        cache(key, obj);
                    }
                }else{
                    logger.debug("from redis...");
                    obj = cacheValue;
                }
            }
        }else{
            logger.debug("from redis...");
            obj = cacheValue;
        }
        return obj;
    }

    private String cacheKey(ProceedingJoinPoint pjp){
        Signature o2 = pjp.getSignature();
        StringBuilder keyBuilder = new StringBuilder(o2.toString()).append(":").append(o2.getName());
        Object[] args = pjp.getArgs();
        for(Object o : args){
            keyBuilder.append(":").append(o.toString());
        }
        return keyBuilder.toString();
    }

    private Object getFromCache(String key){
        return redisService.get(key);
    }

    private boolean cache(String key,Object value){
        redisService.set(key,value);
        return true;
    }
}
