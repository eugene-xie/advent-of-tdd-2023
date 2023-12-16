package org.advent.day2;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.advent.day2.Game;

public class TestGameShould {
   @Test
   void test_should_get_gameID_1(){
        Game game = new Game("Game 1: 1 red");
        assertThat(game.getGameID(), equalTo(1));
   }
   @Test
   void test_should_get_coloredCube(){
        Game game = new Game("Game 2: 2 red");
        assertThat(game.greenMax(), equalTo(0));
        assertThat(game.blueMax(), equalTo(0));
        assertThat(game.redMax(), equalTo(2));

        game = new Game("Game 3: 3 green");
        assertThat(game.greenMax(), equalTo(3));
        assertThat(game.blueMax(), equalTo(0));
        assertThat(game.redMax(), equalTo(0));

        game = new Game("Game 4: 4 blue");
        assertThat(game.greenMax(), equalTo(0));
        assertThat(game.blueMax(), equalTo(4));
        assertThat(game.redMax(), equalTo(0));

        game = new Game("Game 5: 7 green, 8 blue, 9 red; 10 green");
        assertThat(game.greenMax(), equalTo(10));
        assertThat(game.blueMax(), equalTo(8));
        assertThat(game.redMax(), equalTo(9));

        game = new Game("Game 7: 11 green, 12 red; 13 blue, 14 red");
        assertThat(game.getGameID(), equalTo(7));
        assertThat(game.greenMax(), equalTo(11));
        assertThat(game.blueMax(), equalTo(13));
        assertThat(game.redMax(), equalTo(14));
   }
}
