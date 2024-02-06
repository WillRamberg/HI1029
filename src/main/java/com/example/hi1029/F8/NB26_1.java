package com.example.hi1029.F8;

import java.util.HashMap;

public class NB26_1 {

    public static void main(String[] args) {
        String[] words = new String[]{"Apa", "Banan", "Banan", "Apa", "Apa"};
        System.out.println(countMostCommon(words));
    }

    public static int countMostCommon(String[] words) {
        HashMap<String, Integer> wordCount = new HashMap<>(words.length);

        int mostCommon = 0;
        for(String word : words){
            wordCount.put(word, wordCount.containsKey(word) ? wordCount.get(word) + 1 : 1);
            int count = wordCount.get(word);
            if(count > mostCommon)
                mostCommon = count;
        }
        return mostCommon;
    }
}
