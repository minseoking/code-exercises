package com.study.springtest.coverage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoverageTest {

    @Test
    @DisplayName("조건 테스트")
    public void conditionTest() {
        int x = 0;
        int y = 0;
        if (x == 0 || y == 0) {
            System.out.println("x or y is zero");
        } else {
            System.out.println("x and y is not zero");
        }
    }
}
