package com.lfw.concurrent;

import java.util.concurrent.TimeUnit;

public class TimedWaitingStatusExample {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "TIME_WAITING").start();
    }
}
