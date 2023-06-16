package com.study.javadesignpattern.creational.singleton;

import java.util.Random;

public class LazyHolderSingleton {

    public String value;

    private LazyHolderSingleton(String value) {
        this.value = value;
    }

    public static LazyHolderSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LazyHolderSingleton INSTANCE = new LazyHolderSingleton("test" + new Random().nextInt(100));
    }
}
