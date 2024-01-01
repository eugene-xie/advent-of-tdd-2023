package org.advent.day3;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestEnginePartShould {
    @Test
    void test_should_get_2_parts() {
        EnginePartReader engPartReader = new EnginePartReader("467..114..");
        EnginePart[] engParts = new EnginePart[engPartReader.getNumbers().size()];
        engPartReader.getNumbers().toArray(engParts);
        assertThat(engParts[0].getPartNumber(), equalTo(467));
        assertThat(engParts[1].getPartNumber(), equalTo(114));
    }

    @Test
    void test_should_get_0_part() {
        EnginePartReader engPartReader = new EnginePartReader("...*......");
        assertThat(engPartReader.getNumbers().size(), equalTo(0));
    }
        
    @Test
    void test_should_get_1_part(){
        EnginePartReader engPartReader = new EnginePartReader("617*......");
        EnginePart[] engParts = new EnginePart[engPartReader.getNumbers().size()];
        engPartReader.getNumbers().toArray(engParts);
        assertThat(engParts[0].getPartNumber(), equalTo(617));
    }
}