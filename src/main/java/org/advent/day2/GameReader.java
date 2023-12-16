package org.advent.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameReader {
    List<Game> games = new ArrayList<>();

    public GameReader(BufferedReader reader) {
        try {
            for (String line; (line = reader.readLine()) != null;) {
                Game g = new Game(line);
                games.add(g);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int sumOfPossibleGameID(int greenMax, int blueMax, int redMax){
        int ID_sum = 0;
        for (Game g : games){
            if(g.greenMax() <= greenMax && g.blueMax() <= blueMax && g.redMax() <= redMax){
                ID_sum += g.getGameID();
            }
        }

        return ID_sum;
    }

    public int powerOfGames(){
        int powerOfGame = 0;
        for (Game g : games) {
            powerOfGame += g.greenMax()*g.blueMax()*g.redMax();
        }
        return powerOfGame;
    }
}