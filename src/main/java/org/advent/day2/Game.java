package org.advent.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private int gameID;
    private int greenMax = 0, blueMax = 0, redMax = 0;

    public Game(String setOfGame) {
        parseGame(setOfGame);
    }

    private void parseGame(String game) {
        int g, b, r;
        Matcher matcher = Pattern.compile("(?<=Game)(\\s+)(\\d+)").matcher(game);

        if (matcher.find()) {
            gameID = Integer.parseInt(matcher.group(2));
        }

        matcher = Pattern.compile("(\\d+)(\\s+)(?=(green))").matcher(game);
        while (matcher.find()) {
            g = Integer.parseInt(matcher.group(1));
            if (g > greenMax) {
                greenMax = g;
            }
        }

        matcher = Pattern.compile("(\\d+)(\\s+)(?=(blue))").matcher(game);
        while (matcher.find()) {
            b = Integer.parseInt(matcher.group(1));
            if (b > blueMax) {
                blueMax = b;
            }
        }

        matcher = Pattern.compile("(\\d+)(\\s+)(?=(red))").matcher(game);
        while (matcher.find()) {
            r = Integer.parseInt(matcher.group(1));
            if (r > redMax) {
                redMax = r;
            }
        }
    }

    public int getGameID() {
        return gameID;
    }

    public int greenMax() {
        return greenMax;
    }

    public int blueMax() {
        return blueMax;
    }

    public int redMax() {
        return redMax;
    }

    public static void main(String[] args) {
        String game = "Game 87: 1 blue; 6 red, 6 green; 1 blue, 9 red, 3 green";

        Matcher matcher = Pattern.compile("(?<=Game)(\\s+)(\\d+)").matcher(game);
        if (matcher.find()) {
            System.out.println("Game ID is: " + matcher.group(2));
        }

        String splited[] = game.split(":");
        for (String s : splited) {
            System.out.println(s);
        }

        String color[] = splited[1].split(";");
        for (String s : color) {
            matcher = Pattern.compile("(\\d+)(\\s+)(?=(red))").matcher(s);
            if (matcher.find()) {
                System.out.println("red: " + matcher.group(1));
            }

            matcher = Pattern.compile("(\\d+)(\\s+)(?=(blue))").matcher(s);
            if (matcher.find()) {
                System.out.println("blue: " + matcher.group(1));
            }

            matcher = Pattern.compile("(\\d+)(\\s+)(?=(green))").matcher(s);
            if (matcher.find()) {
                System.out.println("green: " + matcher.group(1));
            }
        }
    }
}
