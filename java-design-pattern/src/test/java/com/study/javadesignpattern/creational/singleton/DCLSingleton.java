package com.study.javadesignpattern.creational.singleton;

import java.util.Random;

public class DCLSingleton {
    private static volatile DCLSingleton instance;
    public String value;

    private DCLSingleton(String value) {

        this.value = value;
    }

    public static DCLSingleton getInstance() {
        if (instance == null) {
            synchronized (DCLSingleton.class) {
                if (instance == null) {
                    instance = new DCLSingleton("test" + new Random().nextInt(100));
                }
            }
        }

        return instance;
    }
}