package com.lfw.concurrent;

import java.util.concurrent.TimeUnit;

public class BlockedThreadInterruptExample2 extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                TimeUnit.SECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //...
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("线程被中断");
    }

    public static void main(String[] args) throws InterruptedException {
        BlockedThreadInterruptExample blocked = new BlockedThreadInterruptExample();
        blocked.start();
        TimeUnit.MICROSECONDS.sleep(100);
        System.out.println("before:InterruptExample 中断状态：" + blocked.isInterrupted());
        blocked.interrupt();
        System.out.println("after:InterruptExample 中断状态：" + blocked.isInterrupted());
    }
}
