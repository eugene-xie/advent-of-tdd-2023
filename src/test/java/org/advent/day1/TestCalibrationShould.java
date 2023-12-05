package org.advent.day1;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestCalibrationShould {

    @Test
    void test_should_return_0_first_digit() {
        int calValue = Calibration.get1stDigit("abc");

        assertThat(calValue, equalTo(0));
    }

    @Test
    void test_should_return_first_digit() {
        int calValue = Calibration.get1stDigit("a89b");

        assertThat(calValue, equalTo(8));

        calValue = Calibration.get1stDigit("123c");

        assertThat(calValue, equalTo(1));
    }

    @Test
    void test_should_return_0_last_digit() {
        int calValue = Calibration.getLastDigit("abc");

        assertThat(calValue, equalTo(0));
    }

    @Test
    void test_should_return_last_digit() {
        int calValue = Calibration.getLastDigit("a89c");

        assertThat(calValue, equalTo(9));
    }

    @Test
    void test_should_return_calvalue_0() {
        int calValue = Calibration.getCalVal("abcd");

        assertThat(calValue, equalTo(0));
    }

    @Test
    void test_should_return_calvalue_11() {
        int calValue = Calibration.getCalVal("1");
        assertThat(calValue, equalTo(11));
    }

    @Test
    void test_should_return_calvalue_00() {
        int calValue = Calibration.getCalVal("0");
        assertThat(calValue, equalTo(0));
    }

    @Test
    void test_should_return_calvalue_12() {
        int calValue = Calibration.getCalVal("12");
        assertThat(calValue, equalTo(12));
    }

    @Test
    void test_should_return_calvalue_23() {
        int calValue = Calibration.getCalVal("1");
        assertThat(calValue, equalTo(11));
        calValue = Calibration.getCalVal("a");
        assertThat(calValue, equalTo(0));
        calValue = Calibration.getCalVal("one");
        assertThat(calValue, equalTo(11));
        calValue = Calibration.getCalVal("two");
        assertThat(calValue, equalTo(22));
        calValue = Calibration.getCalVal("three");
        assertThat(calValue, equalTo(33));
        calValue = Calibration.getCalVal("zero");
        assertThat(calValue, equalTo(0));
        calValue = Calibration.getCalVal("nine");
        assertThat(calValue, equalTo(99));
        calValue = Calibration.getCalVal("10");
        assertThat(calValue, equalTo(10));
        calValue = Calibration.getCalVal("a1b2c3");
        assertThat(calValue, equalTo(13));
        calValue = Calibration.getCalVal("aonebtwo");
        assertThat(calValue, equalTo(12));
        calValue = Calibration.getCalVal("aoneb2");
        assertThat(calValue, equalTo(12));
        calValue = Calibration.getCalVal("a1btwo");
        assertThat(calValue, equalTo(12));

    }
}