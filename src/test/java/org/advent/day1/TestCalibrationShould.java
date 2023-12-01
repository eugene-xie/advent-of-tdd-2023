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
        int calValue = Calibration.getCalVal("a2c3d");

        assertThat(calValue, equalTo(23));

        calValue = Calibration.getCalVal("abcd9");

        assertThat(calValue, equalTo(99));
    }
}