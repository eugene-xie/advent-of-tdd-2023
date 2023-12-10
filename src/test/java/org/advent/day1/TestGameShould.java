package org.advent.day1;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestGameShould {
   @Test
   void test_should_get_gameID_1(){
        Game game = new Game("Game 1: 1 red");
        assertThat(game.getGameID(), equalTo(1));
   }
   @Test
   void test_should_get_coloredCube(){
        Game game = new Game("Game 2: 2 red");
        assertThat(game.getAllSets().get(0)[2], equalTo(2));

        game = new Game("Game 3: 3 green");
        assertThat(game.getAllSets().get(0)[0], equalTo(3));

        game = new Game("Game 4: 4 blue");
        assertThat(game.getAllSets().get(0)[1], equalTo(4));

        game = new Game("Game 5: 7 green, 8 blue, 9 red; 10 green");
        assertThat(game.getAllSets().get(0)[0], equalTo(7));
        assertThat(game.getAllSets().get(0)[1], equalTo(8));
        assertThat(game.getAllSets().get(0)[2], equalTo(9));
        assertThat(game.getAllSets().get(1)[0], equalTo(10));

        game = new Game("Game 7: 11 green, 12 red; 13 blue, 14 red");
        assertThat(game.getGameID(), equalTo(7));
        assertThat(game.getAllSets().get(0)[0], equalTo(11));
        assertThat(game.getAllSets().get(0)[1], equalTo(0));
        assertThat(game.getAllSets().get(0)[2], equalTo(12));
        assertThat(game.getAllSets().get(1)[0], equalTo(0));
        assertThat(game.getAllSets().get(1)[1], equalTo(13));
        assertThat(game.getAllSets().get(1)[2], equalTo(14));
   }
}
