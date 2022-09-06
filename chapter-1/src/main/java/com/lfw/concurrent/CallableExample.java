package com.lfw.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class CallableExample implements Callable<String> {
    public final static Logger logger = LoggerFactory.getLogger(CallableExample.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableExample callableExample = new CallableExample();
        FutureTask<String> futureTask = new FutureTask<>(callableExample);
        Thread thread = new Thread(futureTask);
        thread.start();
        logger.info("result:{}", futureTask.get());
    }

    @Override
    public String call() throws Exception {
        return "执行结果：SUCCESS";
    }
}
