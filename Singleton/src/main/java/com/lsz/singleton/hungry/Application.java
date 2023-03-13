package com.lsz.singleton.hungry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        List<Singleton> singletons = new ArrayList<Singleton>(1000);
        int count = 1000;
        final CountDownLatch countDownLatch = new CountDownLatch(1000);
        while (count-- > 0) {
            new Thread(() -> {
                singletons.add(Singleton.getInstance());
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        Singleton prev = singletons.get(0);
        for (Singleton singleton : singletons) {
            if (singleton != prev) {
                System.out.println("单例模式有问题");
                break;
            }
            prev = singleton;
        }
    }
}
