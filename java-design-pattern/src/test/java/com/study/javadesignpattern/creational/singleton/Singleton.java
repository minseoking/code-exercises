package com.study.javadesignpattern.creational.singleton;

import java.util.Random;

public class Singleton {
    private static volatile Singleton instance;
    public String value;

    private Singleton(String value) {

        this.value = value;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton("test" + new Random().nextInt(100));
        }

        return instance;
    }
}