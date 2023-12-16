package org.advent.day2;

import org.advent.day2.GameReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestGameReaderShould {

    private GameReader gameReader;

   @Test
   void test_should_get_1(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenThrow(new IOException());
        assertThrows(RuntimeException.class, () -> new GameReader(mockReader));
   }

   @Test
   void test_should_get_0(@Mock BufferedReader mockReader) throws IOException {
    when(mockReader.readLine()).thenReturn("Game 1: 7 green, 4 blue, 3 red; 4 blue, 10 red, 1 green; 1 blue, 9 red")
            .thenReturn("Game 2: 2 red, 4 blue, 3 green; 5 green, 3 red, 1 blue; 3 green, 5 blue, 3 red")
            .thenReturn("Game 3: 12 red, 1 blue; 6 red, 2 green, 3 blue; 2 blue, 5 red, 3 green")
            .thenReturn(null);
    gameReader = new GameReader(mockReader);
    assertThat(gameReader.sumOfPossibleGameID(7, 5, 12), equalTo(6));
    assertThat(gameReader.sumOfPossibleGameID(3, 4, 12), equalTo(3));
    }

    @Test
    void test_should_power_0(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("Game 1: 7 green, 4 blue, 3 red; 4 blue, 10 red, 1 green; 1 blue, 9 red")
        .thenReturn("Game 2: 2 red, 4 blue, 3 green; 5 green, 3 red, 1 blue; 3 green, 5 blue, 3 red")
        .thenReturn("Game 3: 12 red, 1 blue; 6 red, 2 green, 3 blue; 2 blue, 5 red, 3 green")
        .thenReturn(null);

        gameReader = new GameReader(mockReader);
        assertThat(gameReader.powerOfGames(), equalTo(463));
    }
}