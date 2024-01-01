package org.advent.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnginePartReader {
    private List<EnginePart> numbers = new ArrayList<> ();

    public EnginePartReader(String magicCode){
        Matcher matcher = Pattern.compile("[\\d]+").matcher(magicCode);
        while (matcher.find()){
            EnginePart engPart = new EnginePart(Integer.parseInt(matcher.group()), matcher.start());
            numbers.add(engPart);
        }
    }

    public List<EnginePart> getNumbers(){
        return numbers;
    }
}
