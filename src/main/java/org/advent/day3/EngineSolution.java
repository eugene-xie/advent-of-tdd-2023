package org.advent.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EngineSolution {
    private List<List<EnginePart>> numbers = new ArrayList<>();
    private List<List<Symbol>> symbols = new ArrayList<>();
    private int SumOfEngPartNumber = 0;
    private int sumOfRatios = 0;

    public EngineSolution(BufferedReader bufReader) {
        EnginePartReader enginePartReader;
        SymbolReader symbolReader;
        try {
            for (String line; (line = bufReader.readLine()) != null;) {
                enginePartReader = new EnginePartReader(line);
                numbers.add(enginePartReader.getNumbers());

                symbolReader = new SymbolReader(line);
                symbols.add(symbolReader.getSymbols());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<List<EnginePart>> getNumbers() {
        return numbers;
    }

    public int getSumOfEnginePartNumber() {
        return SumOfEngPartNumber;
    }

    public int getSumOfRatios() {
        return sumOfRatios;
    }

    public void findEnginePartsAndGears() {
        int gearAdjacentCount = 0;
        int ratio = 0;
        int gearPart1 = 0;
        int gearPart2 = 0;

        // For each line of symbols
        for (int i = 0; i < symbols.size(); i++) {
            List<Symbol> symList = symbols.get(i);
            List<EnginePart> engList = numbers.get(i);

            // For each symbol
            for (int j = 0; j < symList.size(); j++) {
                gearAdjacentCount = 0;
                ratio = 0;
                gearPart1 = 0;
                gearPart2 = 0;

                int symIndex = symList.get(j).getStartIndex();

                // Search the part Number of the same line
                for (int k = 0; k < engList.size(); k++) {
                    EnginePart engPart = engList.get(k);
                    if (engPart != null
                            && (engPart.getStartIndex() == symIndex + 1 || engPart.getEndIndex() == symIndex - 1)) {
                        SumOfEngPartNumber += engPart.getPartNumber();
                        gearAdjacentCount++;
                        if (gearAdjacentCount == 1) {
                            gearPart1 = engPart.getPartNumber();
                        }
                        if (gearAdjacentCount == 2) {
                            gearPart2 = engPart.getPartNumber();
                        }
                        // Since it has been counted, set it to 0 to avoid duplication
                        engPart.setPartNumber(0);
                    }

                }

                // Search the part number of the previous line
                if (i > 0) {

                    List<EnginePart> engListPrevious = numbers.get(i - 1);
                    for (int w = 0; w < engListPrevious.size(); w++) {
                        if (engListPrevious.get(w).getStartIndex() <= symIndex + 1
                                && engListPrevious.get(w).getEndIndex() >= symIndex - 1) {
                            SumOfEngPartNumber += engListPrevious.get(w).getPartNumber();
                            gearAdjacentCount++;
                            if (gearAdjacentCount == 1) {
                                gearPart1 = engListPrevious.get(w).getPartNumber();
                            }
                            if (gearAdjacentCount == 2) {
                                gearPart2 = engListPrevious.get(w).getPartNumber();
                            }

                            engListPrevious.get(w).setPartNumber(0);
                        }
                    }
                }

                // Search the part number of the next line
                if (i < numbers.size() - 1) {

                    List<EnginePart> engListNext = numbers.get(i + 1);
                    for (int w = 0; w < engListNext.size(); w++) {
                        if (engListNext.get(w).getStartIndex() <= symIndex + 1
                                && engListNext.get(w).getEndIndex() >= symIndex - 1) {
                            SumOfEngPartNumber += engListNext.get(w).getPartNumber();
                            gearAdjacentCount++;
                            if (gearAdjacentCount == 1) {
                                gearPart1 = engListNext.get(w).getPartNumber();
                            }
                            if (gearAdjacentCount == 2) {
                                gearPart2 = engListNext.get(w).getPartNumber();
                            }

                            engListNext.get(w).setPartNumber(0);
                        }
                    }
                }
                if (gearAdjacentCount == 2) {
                    ratio = gearPart1 * gearPart2;
                    sumOfRatios += ratio;
                }

            }
        }
    }

    public static void main(String[] args) {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("day3-engine.txt");
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);
        EngineSolution engSolution = new EngineSolution(reader);

        engSolution.findEnginePartsAndGears();
        int sumOfPartNumber = engSolution.getSumOfEnginePartNumber();
        int sumOfRatios = engSolution.getSumOfRatios();

        System.out.println("the sum of the part number is: " + sumOfPartNumber);
        System.out.println("the sum of the gear ratio number is: " + sumOfRatios);
    }

    public List<List<Symbol>> getSymbols() {
        return symbols;
    }
}