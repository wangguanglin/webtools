package com.boxflux.tool.web.common.waitNotify;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by wangguanglin on 2019/6/24.
 */
public class Waiter implements Runnable {

    public Waiter(Message msg) {
        this.msg = msg;
    }

    private Message msg;
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg){
            System.out.println(name+" : waiting to get notified at time:"+ LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));
            try {
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+" : waiter thread got notified at time:"+LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));
        //process the message now
        System.out.println(name+" : processed: "+msg.getMsg());
    }
}
