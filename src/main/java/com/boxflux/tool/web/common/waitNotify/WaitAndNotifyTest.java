package com.boxflux.tool.web.common.waitNotify;

/**
 * Created by wangguanglin on 2019/6/24.
 */
public class WaitAndNotifyTest {

    public static void main(String[] args) {
//        testNotify();

        testNotifyAll();
    }

    public static void testNotify() {
        Message msg = new Message("process it");

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();

        Waiter waiter2 = new Waiter(msg);
        new Thread(waiter2, "waiter2").start();

        Notifier notifier = new Notifier(msg, false);
        new Thread(notifier, "notifier").start();

        System.out.println("All the threads are started");
    }

    public static void testNotifyAll() {
        Message msg = new Message("process it");

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();

        Waiter waiter2 = new Waiter(msg);
        new Thread(waiter2, "waiter2").start();

        Notifier notifier = new Notifier(msg, false);
        new Thread(notifier, "notifier").start();

        System.out.println("All the threads are started");
    }
}
