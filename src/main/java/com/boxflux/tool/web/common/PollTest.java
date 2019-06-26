package com.boxflux.tool.web.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangguanglin on 2019/6/21.
 */
public class PollTest {

    public static class MyJob implements Runnable{
        @Override
        public void run() {

            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do.....");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++) {
            executor.execute(new MyJob());
        }
        TimeUnit.SECONDS.sleep(10);
        executor.shutdown();
    }
}
