package org.advent.day3;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class TestSchematicShould {
    @Test
    public void test_should_1() {
        Schematic s1 = new Symbol(9, 'A');
        Schematic s2 = new EnginePart(678, 10);
        assertThat(s1.getStartIndex(), equalTo(1));
        assertThat(s2.getStartIndex(), equalTo(10));
        assertThat(s2.getEndIndex(), equalTo(13));
        assertThat(((EnginePart) s2).getPartNumber(), equalTo(678));
    }
}