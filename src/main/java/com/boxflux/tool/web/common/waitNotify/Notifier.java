package com.boxflux.tool.web.common.waitNotify;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangguanglin on 2019/6/24.
 */
public class Notifier implements Runnable {

    private Message msg;

    private Boolean isAll = true;

    public Notifier(Message msg, Boolean isAll) {
        this.msg = msg;
        this.isAll = isAll;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");
        try {
            TimeUnit.SECONDS.sleep(3);

            synchronized (msg){
                System.out.println(name + " : got the msg : "+msg.getMsg());

                msg.setMsg(name + " : Notifier work done");

                if(isAll){
                    msg.notifyAll();
                }else{
                    msg.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
