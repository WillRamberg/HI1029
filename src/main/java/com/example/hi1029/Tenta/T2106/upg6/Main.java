package com.example.hi1029.Tenta.T2106.upg6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main{
        public static void main(String[] args) {
            String[] words ={"tag", "min", "hand", "tag", "min", "vita", "arm", "tag", "mina", "smala", "axlars", "längtan"};
            System.out.println(nrUniqueWith_a(words));

        }

        public static int nrUniqueWith_a(String[] words){
            Set<String> map = new HashSet<>();
            int unique = 0;
            for(String word : words){
                if(map.add(word)){
                    if(word.contains("a"))
                        unique++;
                }
            }
            return unique;
        }
}
