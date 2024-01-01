package org.advent.day3;

public class Symbol extends Schematic{
    private char c;

    public Symbol(int index, char c){
        this.symbol = true;
        this.c = c;
        this.startIndex = index;
        this.endIndex = index;
    }

    public char getSymbol() {
        return c;
    }
}
