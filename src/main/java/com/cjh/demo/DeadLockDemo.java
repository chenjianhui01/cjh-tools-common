package com.cjh.demo;

/**
 * @Description:
 * @author: chenJianHui
 * @date: 2022/7/8 09:24
 */
public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resources1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waitting get resources2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + " get resources2");
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resources2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waitting get resources1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + " get resources1");
                }
            }
        }, "线程2").start();



    }
}
