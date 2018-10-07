package com.compony.spring.test.core;

import java.util.concurrent.CountDownLatch;

public abstract class TaskRunner implements Runnable {
    CountDownLatch countDownLatch;

    @Override
    public void run() {
        call();
        countDownLatch.countDown();
    }

    protected abstract void call();

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
}
