package com.study.springtest.coverage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoverageTest {

    private final Coverage coverage = new Coverage();

    @Test
    @DisplayName("구문 테스트")
    public void statementTest() {
        coverage.test(1, 0);
        coverage.isVip("민석");
    }

    @Test
    @DisplayName("조건 테스트")
    public void conditionTest() {
        coverage.test(0, 0);
        coverage.test(0, 1);
        coverage.test(1, 0);
        coverage.test(1, 1);

    }

    @Test
    @DisplayName("결정 테스트")
    public void decisionTest() {
        coverage.test(1, 1);
        coverage.test(1, 0);
    }
}
