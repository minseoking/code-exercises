package com.study.javadesignpattern.creational.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonTest {

    @Test
    @DisplayName("싱글톤 테스트")
    public void singletonTest() throws InterruptedException {
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

        System.out.println(values);
        for (int i = 1; i < values.size(); i++) {
            System.out.println(values.get(i - 1));
            System.out.println(values.get(i));
            //assertEquals(values.get(i), values.get(i - 1));
        }
    }

    @Test
    @DisplayName("레이지 싱글톤 테스트")
    public void lazySingletonTest() throws InterruptedException {
        int numThreads = 5;
        CountDownLatch latch = new CountDownLatch(numThreads);

        List<Thread> threads = new ArrayList<>();
        List<String> values = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                values.add(LazySingleton.getInstance().value);

                latch.countDown();
            });
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }

        latch.await();

        System.out.println(values);
        for (int i = 1; i < numThreads; i++) {
            System.out.println(values.get(i - 1));
            System.out.println(values.get(i));
            assertEquals(values.get(i), values.get(i - 1));
        }
    }

    @Test
    @DisplayName("더블 체크 락킹 싱글톤 테스트")
    public void dclSingletonTest() throws InterruptedException {
        int numThreads = 5;
        CountDownLatch latch = new CountDownLatch(numThreads);

        List<Thread> threads = new ArrayList<>();
        List<String> values = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                values.add(DCLSingleton.getInstance().value);

                latch.countDown();
            });
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }

        latch.await();

        System.out.println(values);
        for (int i = 1; i < numThreads; i++) {
            System.out.println(values.get(i - 1));
            System.out.println(values.get(i));
            assertEquals(values.get(i), values.get(i - 1));
        }
    }

    @Test
    @DisplayName("레이지 홀더 싱글톤 테스트")
    public void lazyHolderSingletonTest() throws InterruptedException {
        int numThreads = 5;
        CountDownLatch latch = new CountDownLatch(numThreads);

        List<Thread> threads = new ArrayList<>();
        List<String> values = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                values.add(LazyHolderSingleton.getInstance().value);

                latch.countDown();
            });
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
        }

        latch.await();

        System.out.println(values);
        for (int i = 1; i < numThreads; i++) {
            System.out.println(values.get(i - 1));
            System.out.println(values.get(i));
            assertEquals(values.get(i), values.get(i - 1));
        }
    }
}
