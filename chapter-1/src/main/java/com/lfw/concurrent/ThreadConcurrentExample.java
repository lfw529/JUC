package com.lfw.concurrent;

public class ThreadConcurrentExample implements Runnable {

    private static final Long num = 100000000L;

    private int sum;

    public ThreadConcurrentExample(int sum) {
        this.sum = sum;
    }

    public static void runWithThread() throws InterruptedException {
        long start = System.currentTimeMillis();
        //执行两个任务
        //1.计算指定目标数的和
        int tempSum = 0;
        ThreadConcurrentExample tce = new ThreadConcurrentExample(tempSum);
        Thread thread = new Thread(tce);
        thread.start();
        //2.同步计算遍历次数
        int count = 0;
        for (int i = 0; i < num; i++) {
            count++;
        }
        thread.join();  //确保线程执行结束|等待线程死亡
        long totalFree = System.currentTimeMillis() - start;
        System.out.println("runWithThread: totalFree=" + totalFree + ",count=" + count);
    }

    public static void runWithSerial() throws InterruptedException {
        long start = System.currentTimeMillis();
        //执行两个任务
        //1.计算指定目标数的和
        int tempSum = 0;
        for (int i = 0; i < num; i++) {
            tempSum += 1;
        }
        //2.同步计算遍历次数
        int count = 0;
        for (int i = 0; i < num; i++) {
            count++;
        }
        long totalFree = System.currentTimeMillis() - start;
        System.out.println("runWithSerial: totalFree=" + totalFree + ",count=" + count);
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            synchronized (this) {
                sum += 1;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        runWithThread();
        runWithSerial();
    }
}
