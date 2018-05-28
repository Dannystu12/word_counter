package com.example.danielstewart.wordcounter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCounter {
    public static int countWords(String string){
        return normalise(string).split(" ").length;
    }

    public static HashMap<String, Integer> getCountsMap(String string){
        HashMap<String, Integer> result = new LinkedHashMap<>();
        String[] words = normalise(string).split(" ");
        for(String word : words){
            int count = result.getOrDefault(word, 0);
            count++;
            result.put(word, count);
        }

        return result;
    }

    private static String normalise(String string){
        // Remove non ascii chars and shift to lower case
        return string.replaceAll("[^a-zA-Z1-9 ]", "").toLowerCase();
    }
}
