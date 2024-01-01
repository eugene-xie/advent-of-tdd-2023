package org.advent.day2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class GameSolution {
    
    public static void main(String[] args) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("day2-games.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        GameReader gameReader = new GameReader(reader);
        System.out.println("Sum of GameID: " + gameReader.sumOfPossibleGameID(13, 14, 12));

        System.out.println("Power of Games: " + gameReader.powerOfGames());
    }
}