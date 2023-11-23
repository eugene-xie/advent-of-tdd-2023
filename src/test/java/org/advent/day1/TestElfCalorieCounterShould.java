package org.advent.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestElfCalorieCounterShould {

    private ElfCalorieCounter elfCalorieCounter;

    @Test
    void throw_an_runtime_exception_when_reader_throws_io(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenThrow(new IOException());
        assertThrows(RuntimeException.class, () -> new ElfCalorieCounter(mockReader));
    }

    @Test
    void should_create_one_elf_with_maximum_calories_4000(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("3000")
                .thenReturn("1000")
                .thenReturn(null);
        elfCalorieCounter = new ElfCalorieCounter(mockReader);
        assertThat(elfCalorieCounter.maxCalories(), equalTo(4000));
    }

    @Test
    void should_create_two_elves_with_max_of_10_000(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("1000")
                .thenReturn("3000")
                .thenReturn("")
                .thenReturn("5000")
                .thenReturn("5000")
                .thenReturn(null);
        elfCalorieCounter = new ElfCalorieCounter(mockReader);
        assertThat(elfCalorieCounter.maxCalories(), equalTo(10_000));
    }

    @Test
    void shuold_get_top_3_elf_with_most_calories(@Mock BufferedReader mockReader) throws IOException {
        when (mockReader.readLine()).thenReturn("2000")
                .thenReturn("1000")
                .thenReturn("")
                .thenReturn("8000")
                .thenReturn("")
                .thenReturn("3000")
                .thenReturn("2000")
                .thenReturn("")
                .thenReturn("4000")
                .thenReturn("")
                .thenReturn("7000")
                .thenReturn(null);
        elfCalorieCounter = new ElfCalorieCounter(mockReader);
        assertThat(elfCalorieCounter.topNCaloriesInTotal(3), equalTo(20000));
    }
}