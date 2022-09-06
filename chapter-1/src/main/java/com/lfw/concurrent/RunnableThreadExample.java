package com.lfw.concurrent;

import lombok.extern.slf4j.Slf4j;
import java.util.logging.Logger;

@Slf4j
public class RunnableThreadExample extends OtherClass implements Runnable {
    private static String name = RunnableThreadExample.class.getName();
    private static Logger log = Logger.getLogger(name);

    @Override
    public void run() {
        System.out.println(name);
        log.info("Hello Logging World !");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableThreadExample());
        thread.start();
    }
}
