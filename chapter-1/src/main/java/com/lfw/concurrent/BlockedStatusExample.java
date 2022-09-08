package com.lfw.concurrent;

public class BlockedStatusExample implements Runnable {
    public static void main(String[] args) {
        new Thread(new BlockedStatusExample(), "BLOCKED_T1").start();
        new Thread(new BlockedStatusExample(), "BLOCKED_T2").start();
    }

    @Override
    public void run() {
        synchronized (BlockedStatusExample.class) {
            //一直不释放锁
            while (true) {
            }
        }
    }
}
