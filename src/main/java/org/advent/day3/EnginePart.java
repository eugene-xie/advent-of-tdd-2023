package org.advent.day3;

public class EnginePart extends Schematic {
    private int partNumber;

    public EnginePart(int partNumber, int startIndex) {
        this.partNumber = partNumber;
        this.startIndex = startIndex;

        this.endIndex = startIndex + (partNumber+"").length() -1;
        this.symbol = false;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }
}
