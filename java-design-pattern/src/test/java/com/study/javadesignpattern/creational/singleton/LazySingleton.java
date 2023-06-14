package com.study.javadesignpattern.creational.singleton;

import java.util.Random;

public class LazySingleton {
    private static volatile LazySingleton instance;
    public String value;

    private LazySingleton(String value) {

        this.value = value;
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton("test" + new Random().nextInt(100));
        }
        return instance;
    }
}