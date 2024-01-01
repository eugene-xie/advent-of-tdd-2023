package org.advent.day3;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
public class TestEngineSolution {
    EngineSolution engPartSolution;

    @Test
   void test_should_throw_exception(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenThrow(new IOException());
        assertThrows(RuntimeException.class, () -> new EngineSolution(mockReader));
   }

   @Test
   void test_should_get_eng_part_list(@Mock BufferedReader mockReader) throws IOException{
    when(mockReader.readLine())
    .thenReturn("467..114..")
    .thenReturn("...*......")
    .thenReturn("..35..633.")
    .thenReturn("......#...")
    .thenReturn(null); 

    engPartSolution = new EngineSolution(mockReader);
    List<List<EnginePart>> engParts = engPartSolution.getNumbers();
    List<List<Symbol>> symbols = engPartSolution.getSymbols();

   assertThat(engParts.size(), equalTo(4));
   assertThat(engParts.get(0).get(0).getPartNumber(), equalTo(467));
   assertThat(engParts.get(0).get(0).getStartIndex(), equalTo(0));
   assertThat(engParts.get(0).get(0).getEndIndex(), equalTo(2));
   
   assertThat(engParts.get(0).get(1).getPartNumber(), equalTo(114));
   assertThat(engParts.get(0).get(1).getStartIndex(), equalTo(5));
   assertThat(engParts.get(0).get(1).getEndIndex(), equalTo(7));

   assertThat(engParts.get(2).get(0).getPartNumber(), equalTo(35));
   assertThat(engParts.get(2).get(0).getStartIndex(), equalTo(2));
   assertThat(engParts.get(2).get(0).getEndIndex(), equalTo(3));

   assertThat(engParts.get(2).get(1).getPartNumber(), equalTo(633));
   assertThat(engParts.get(2).get(1).getStartIndex(), equalTo(6));
   assertThat(engParts.get(2).get(1).getEndIndex(), equalTo(8));
   
   assertThat(symbols.size(), equalTo(4));
   assertThat(symbols.get(1).get(0).getStartIndex(), equalTo(3));
   assertThat(symbols.get(3).get(0).getEndIndex(), equalTo(6));
   }

   @Test
   void test_should_get_correct_sum(@Mock BufferedReader mockReader) throws IOException{
    when(mockReader.readLine())
        .thenReturn("467..114..")
        .thenReturn("...*......")
        .thenReturn("..35..633.")
        .thenReturn("......#...")
        .thenReturn("617*......")
        .thenReturn(".....+.58.")
        .thenReturn("..592.....")
        .thenReturn("......755.")
        .thenReturn("...$.*....")
        .thenReturn(".664.598..")
        .thenReturn(null);

    engPartSolution = new EngineSolution(mockReader);
    engPartSolution.findEnginePartsAndGears();
    assertThat(engPartSolution.getSumOfEnginePartNumber(), equalTo(4361));
    assertThat(engPartSolution.getSumOfRatios(), equalTo(467835));
   }
}
