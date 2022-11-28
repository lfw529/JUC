package com.lfw.concurrent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadController {
    @GetMapping("/loop")
    public String dumpWhile() {
        new Thread(new WhileThread()).start();
        return "ok";
    }

    @GetMapping("/dead")
    public String dumpDeadLock() {
        Thread a = new ThreadRunA();
        Thread b = new ThreadRunB();
        a.start();
        b.start();
        return "ok";
    }
}

class WhileThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Thread");
        }
    }
}

//线程A
class ThreadRunA extends Thread {
    @Override
    public void run() {
        System.out.println("================A===================");
        synchronized (A.A) {
            System.out.println("我要开始执行任务A..." + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (B.B) {
            }
            System.out.println("我在执行任务结束了A..." + Thread.currentThread().getName() + ":" + B.B.hashCode() + ":" + A.A.hashCode());
        }
    }
}

//线程B
class ThreadRunB extends Thread {
    public void run() {
        System.out.println("================B===================");
        synchronized (B.B) {
            System.out.println("我要开始执行任务B..." + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (A.A) {
            }
            System.out.println("我在执行任务结束了B..." + Thread.currentThread().getName() + ":" + B.B + ":" + A.A);
        }
    }
}

class A {
    static final Integer A = 1;
}

class B {
    static final Integer B = 1;
}