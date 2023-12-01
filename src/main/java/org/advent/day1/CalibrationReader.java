package org.advent.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class CalibrationReader {
    private Collection<String> calibrations = new ArrayList<>();

   public CalibrationReader(BufferedReader bufferedReader) {
        try{
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                calibrations.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
   }

   public int getTotalCalibrationValue(){
    int totalCalibrationValue = 0;
        for (String str : calibrations) {
            totalCalibrationValue += Calibration.getCalVal(str);
        }
    return totalCalibrationValue;
   }
}