package com.lfw.concurrent;

public class DaemonThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("用户线程运行中...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(100);
        System.out.println("主线程执行完毕...");
    }
}
