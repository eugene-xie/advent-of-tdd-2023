package org.advent.day1;

/**
 * Elf that is assigned calories
 */
public class Elf implements Comparable<Elf> {

    private int totalCalories = 0;

    /**
     * Calories carried by the Elf
     * @return total calories
     */
    public int getTotalCalories() {
        return totalCalories;
    }

    /**
     * Add more calories
     * @return new total calories
     */

    public int addCalories(int calories){
        return totalCalories += calories;
    }

    @Override
    public int compareTo(Elf otherElf) {
        return totalCalories - otherElf.getTotalCalories();
    }

}
