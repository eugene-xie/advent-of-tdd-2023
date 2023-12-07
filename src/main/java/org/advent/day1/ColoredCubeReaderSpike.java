package org.advent.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ColoredCubeReaderSpike {
    public static void main(String[] args) {
        List<String> coloredCubes = new ArrayList<>();

        // This will live in the main for this solution
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("day2-games.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        try {
            for (String line; (line = reader.readLine()) != null;) {
                coloredCubes.add(line);
            }
            System.out.println(coloredCubes.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}