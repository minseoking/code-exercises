package com.study.javadesignpattern.creational;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonTest {

    @Test
    public void test() throws InterruptedException {
        int numThreads = 5;
        CountDownLatch latch = new CountDownLatch(numThreads);

        List<Thread> threads = new ArrayList<>();
        List<String> values = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                values.add(Singleton.getInstance().value);

                latch.countDown();
            });
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }

        latch.await();

        for (int i = 1; i < numThreads; i++) {
            System.out.println(values.get(i - 1));
            System.out.println(values.get(i));
            assertEquals(values.get(i), values.get(i - 1));
        }
    }
}
