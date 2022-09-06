package com.lfw.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

@Slf4j
public class ThreadExample extends Thread {
    private static String name = ThreadExample.class.getName();
    private static Logger log = Logger.getLogger(name);

    public void run() {
        log.info("ThreadExample.run");
    }

    public static void main(String[] args) {
        ThreadExample example = new ThreadExample();
        example.start();
    }
}
