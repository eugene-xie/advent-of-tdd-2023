package org.advent.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolReader {
    private List<Symbol> symbols = new ArrayList<>();
    public void addSymbol (Symbol index){
        symbols.add(index);
    }

    public Symbol getSymbol(int index){
        return symbols.get(index);
    }

    public SymbolReader(String engineCode){
        Matcher matcher = Pattern.compile("[~!@#$%^&*()_=+{}\\[\\]:;,<>/|?-]").matcher(engineCode);
        while (matcher.find()){
            Symbol s = new Symbol(matcher.start(), matcher.group().charAt(0));
            symbols.add(s);
        }
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }
}
