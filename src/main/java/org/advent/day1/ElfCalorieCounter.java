package org.advent.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.*;
import java.util.List;
import java.util.stream.Collectors;


public class ElfCalorieCounter {
    private final List<Elf> elves = new ArrayList<>();

    public ElfCalorieCounter(BufferedReader bufferedReader) {
        try {
            Elf elf = new Elf();
            boolean firstRead = true;
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                if(line.isBlank() || firstRead) {
                    elf = new Elf();
                    elves.add(elf);
                    if(firstRead) {
                        elf.addCalories(Integer.parseInt(line));
                        firstRead = false;
                    }
                } else {
                    elf.addCalories(Integer.parseInt(line));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int maxCalories() {
        return elves.stream().max(Elf::compareTo).get().getTotalCalories();
    }
    
    public int topNCaloriesInTotal(int n) {
        return elves.stream().sorted(comparing(Elf::getTotalCalories).reversed()).limit(n).mapToInt(Elf::getTotalCalories).sum();
    }
}
