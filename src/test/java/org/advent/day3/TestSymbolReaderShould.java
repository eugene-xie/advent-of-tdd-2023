package org.advent.day3;

import org.advent.day3.SymbolReader;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestSymbolReaderShould {
   @Test
   void test_should_1(){
    SymbolReader symbolReader = new SymbolReader(".~");
    System.out.println(symbolReader.getSymbols().toArray().toString());
    assertThat(symbolReader.getSymbols().size(), equalTo(1));
    symbolReader = new SymbolReader("~.!.@.#.$.%.^.&.*.(.).-._.=.+.[.].{.}.|.;.:.,.<.>.?./");
    assertThat(symbolReader.getSymbols().size(), equalTo(26));

    symbolReader = new SymbolReader("617*......");
    assertThat(symbolReader.getSymbols().size(), equalTo(1));
    assertThat(symbolReader.getSymbol(0).getSymbol(), equalTo('*'));

    symbolReader = new SymbolReader("...$.*....");
    assertThat(symbolReader.getSymbols().size(), equalTo(2));
    assertThat(symbolReader.getSymbol(0).getSymbol(), equalTo('$'));
    assertThat(symbolReader.getSymbol(1).getSymbol(), equalTo('*'));
   } 
}