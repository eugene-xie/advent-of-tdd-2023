package org.advent.day1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calibration {

    public static int toInt(String intStr) {
        String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        int d1 = 0;

        if (intStr.length() == 1) {
            d1 = Integer.valueOf(intStr);
        } else {
            for (int i = 0; i < 10; i++) {
                if (numbers[i].equalsIgnoreCase(intStr)) {
                    d1 = i;
                    break;
                }
            }
        }
        return d1;
    }

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

        Matcher matcher = Pattern.compile("\\d|one").matcher(aSring);
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
    public static int getLastDigit(String aSring) {
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
    public static int getCalVal(String calibrationStr) {
        int calVal = 0;
        int d1 = 0;
        int d2 = 0;
        String firstMatch = null;
        String lastMatch = null;
        String leftSearchPattern = "(?=(\\d|zero|one|two|three|four|five|six|seven|eight|nine))";

        Matcher matcher = Pattern.compile(leftSearchPattern)
                .matcher(calibrationStr);
        if (matcher.find()) {
            firstMatch = matcher.group(1);
            lastMatch = firstMatch;

            d1 = toInt(firstMatch);

            while (matcher.find()) {
                lastMatch = matcher.group(1);
            }
            d2 = toInt(lastMatch);
        }

        calVal = d1 * 10 + d2;
        return calVal;
    }
}