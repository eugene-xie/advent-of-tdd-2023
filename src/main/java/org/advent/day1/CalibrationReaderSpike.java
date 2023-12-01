package org.advent.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CalibrationReaderSpike {
    public static void main(String[] args) {
        List<String> calibrations = new ArrayList<>();

        //This will live in the main for this solution
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("day1-calibration.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        try {
            for (String line; (line = reader.readLine()) != null; ) {
                calibrations.add(line);
            }
            System.out.println (calibrations.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}