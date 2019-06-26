package com.boxflux.tool.web.common.service;

/**
 * Created by wangguanglin on 2019/6/11.
 */
public class AccessKey {

    private int seconds;

    public AccessKey(int seconds) {
        this.seconds = seconds;
    }

    public static AccessKey withExpire(int seconds) {
        AccessKey accessKey = new AccessKey(seconds);
        return accessKey;
    }

    public Long getExpire(){
        return System.nanoTime()+seconds*1000;
    }
}
