package com.study.springtest.coverage;

public class Coverage {

    public void test(int x, int y) {
        System.out.println("test start");
        if (x == 0 || y == 0) {
            System.out.println("x or y is zero");
        }

        System.out.println("test end");
    }

    public boolean isVip(String name) {
        boolean isVip = false;
        if ("민석".equals(name)) {
            isVip = true;
        }
        return isVip;
    }
}
