package com.example.hi1029.Labb1.U3;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        for (int i = 0; i < 4; i++) l.add("e" + i);
        Iterator<String> iter = l.iterator();
        System.out.println(l);
        iter.next();
        iter.remove();
      
        iter.remove();
        System.out.println(l);
    }
}