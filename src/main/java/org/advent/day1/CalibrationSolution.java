package org.advent.day1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CalibrationSolution {
   public static void main (String [] args) {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("day1-calibration.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        CalibrationReader calReader = new CalibrationReader(reader);
        System.out.println (calReader.getTotalCalibrationValue());
   }
}