package com.lfw.concurrent;

public class WaitingStatusExample {
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (WaitingStatusExample.class) {
                try {
                    WaitingStatusExample.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "WAITING").start();
    }
}
