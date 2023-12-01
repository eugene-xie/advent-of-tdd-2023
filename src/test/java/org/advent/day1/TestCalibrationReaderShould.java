package org.advent.day1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestCalibrationReaderShould {
    
    private CalibrationReader calReader;

    @Test
    void throw_an_runtime_exception_when_reader_throws_io(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenThrow(new IOException());
        assertThrows(RuntimeException.class, () -> new CalibrationReader(mockReader));
    }

    @Test
    void test_should_get_0(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("abc")
                .thenReturn(null);
        calReader = new CalibrationReader(mockReader);
        assertThat(calReader.getTotalCalibrationValue(), equalTo(0));
    }
    @Test
    void test_should_get_11(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("1")
                .thenReturn(null);
        calReader = new CalibrationReader(mockReader);
        assertThat(calReader.getTotalCalibrationValue(), equalTo(11));
    }
    @Test
    void test_should_get_33(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("a1b1c")
                .thenReturn("a2")
                .thenReturn(null);
        calReader = new CalibrationReader(mockReader);
        assertThat(calReader.getTotalCalibrationValue(), equalTo(33));
    }

    @Test
    void test_should_get_30(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("a1bc0")
                .thenReturn("abc2d0e")
                .thenReturn(null);
        calReader = new CalibrationReader(mockReader);
        assertThat(calReader.getTotalCalibrationValue(), equalTo(30));
    }
    @Test
    void test_should_get_88(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("a3b333c")
                .thenReturn("")
                .thenReturn("aaa5555")
                .thenReturn(null);
        calReader = new CalibrationReader(mockReader);
        assertThat(calReader.getTotalCalibrationValue(), equalTo(88));
    }
}