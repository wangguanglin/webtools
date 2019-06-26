package com.boxflux.tool.web.config.accessLimit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangguanglin on 2019/6/11.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AccessLimit {
    String resource() default "default";//资源
    int seconds();//每秒
    int maxCount();//次数
    boolean needLogin()default true;//是否需要登陆
}
