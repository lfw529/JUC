package com.lfw.concurrent;

public class DaemonThreadExample2 {
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                System.out.println("JVM 进程已结束")));
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
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(100);
        System.out.println("主线程执行完毕...");
    }
}
