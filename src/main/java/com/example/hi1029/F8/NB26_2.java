package com.example.hi1029.F8;

import java.util.Arrays;
import java.util.HashSet;

public class NB26_2 {

    public static void main(String[] args) {
        String[] words = new String[]{"Apa", "Banan", "Apa", "Apa", "Kokosnöt"};
        System.out.println(numberOfUniqueWordsHash(words));
    }

    private static int numberOfUniqueWordsHash(String[] words) {
        return new HashSet<String>(Arrays.asList(words)).size();
    }

}
