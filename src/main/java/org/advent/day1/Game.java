package org.advent.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private int gameID;
    private List<int[]> coloredCubeSets = new ArrayList<int []>();

    public Game(String setOfGame) {
        parseGame(setOfGame);
    }

    private void parseGame(String game) {
        Matcher matcher = Pattern.compile("(?<=Game)(\\s+)(\\d+)").matcher(game); 

        if(matcher.find()){
            gameID = Integer.parseInt(matcher.group(2));
        }

        String gameSets[] = game.split(":");
        String color[] = gameSets[1].split(";");
        for (String s : color) {
            int coloredBlock[] = {0, 0, 0};

            matcher = Pattern.compile("(\\d+)(\\s+)(?=(green))").matcher(s);
            if (matcher.find()) {
               coloredBlock[0] = Integer.parseInt(matcher.group(1));
            }
            matcher = Pattern.compile("(\\d+)(\\s+)(?=(blue))").matcher(s);
            if (matcher.find()) {
               coloredBlock[1] = Integer.parseInt(matcher.group(1));
            }
            matcher = Pattern.compile("(\\d+)(\\s+)(?=(red))").matcher(s);
            if (matcher.find()) {
               coloredBlock[2] = Integer.parseInt(matcher.group(1));
            }
            coloredCubeSets.add(coloredBlock);
        }
    }

    public int getGameID(){
        return gameID;
    }

    public List<int []> getAllSets(){
        return coloredCubeSets;
    }


    public int greenMax(){
        return 0;
    }
    
    public int blueMax(){
        return 0;
    }

    public int redMax (){
        return 0;
    }

    public static void main(String[] args) {
        String game = "Game 87: 1 blue; 6 red, 6 green; 1 blue, 9 red, 3 green";

        Matcher matcher = Pattern.compile("(?<=Game)(\\s+)(\\d+)").matcher(game); 
        if (matcher.find()){
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
