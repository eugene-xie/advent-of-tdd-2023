package org.advent.day1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calibration {

    /*
     * Get the 1st digit from a given string and combine them into a 2-digit number
     * Input:
     * a text string
     * return:
     * a 2-digit number, if there is at least one digit in the string.
     * 0, if there is no digit in the string at all
     */
    public static int get1stDigit(String aSring) {
        int calVal = 0;
        
        Matcher matcher = Pattern.compile("\\d").matcher(aSring);
        if (matcher.find()) {
            calVal = Integer.valueOf(matcher.group());
        }
        return calVal;
    }

    /*
     * Get the last digit from a given string and combine them into a 2-digit number
     * Input:
     * a text string
     * return:
     * a 2-digit number, if there is at least one digit in the string.
     * 0, if there is no digit in the string at all
     */
    public static int getLastDigit (String aSring) {
        return get1stDigit(new StringBuilder(aSring).reverse().toString());
    }

    /*
     * Get the 1st and last digit from a given string and combine them into a
     * 2-digit number
     * Input:
     * a text string
     * return:
     * a 2-digit number, if there is at least one digit in the string.
     * 0, if there is no digit in the string at all
     */
    public static int getCalVal (String calibrationStr) {
        int calVal = 0;
        int d1 = 0;
        int d2 = 0;

        d1 = get1stDigit(calibrationStr);
        d2 = getLastDigit(calibrationStr);

        calVal = d1 * 10 + d2;
        return calVal;
    }
}