package com.example.danielstewart.wordcounter;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    @Test
    public void canCount() {
        assertEquals(6, WordCounter.countWords("Mary had a Little Lamb, lamb"));
    }

    @Test
    public void canGetWordCounts(){
        HashMap<String, Integer> result = WordCounter.getCountsMap("Mary had a Little Lamb, lamb");
        assertEquals(2, (int) result.get("lamb"));
    }
}