package org.advent.day3;

public abstract class Schematic {
    boolean symbol;
    int startIndex;
    int endIndex;

    public  boolean isSymbol(){
        return symbol;
    }
    public  int getStartIndex(){
        return startIndex;
    }

    public  int getEndIndex(){
        return endIndex;
    }

    public void setStartIndex(int startIndex){
        this.startIndex = startIndex;
    }
    public void setSymbol(boolean isSymbol) {
        this.symbol = isSymbol;
    }
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}