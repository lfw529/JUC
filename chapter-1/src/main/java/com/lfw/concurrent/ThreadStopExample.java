package com.lfw.concurrent;

public class ThreadStopExample extends Thread {
    @Override
    public void run() {
        try {
            //开始计数
            for (int i = 0; i < 10000; i++) {
                System.out.println("Running.." + i);
            }
            System.out.println("the code that it will be executed");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new ThreadStopExample();
        t1.start();
        Thread.sleep(100);
        t1.stop();
    }
}
