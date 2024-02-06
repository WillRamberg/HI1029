package com.example.hi1029.Labb1.U2;

import com.example.hi1029.Labb1.U2.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>();
        for (int i = 0; i < 4; i++){
            l.add("e" + i);
        }
        System.out.println(l);
        l.remove(3);
        l.add(0,"först");
        l.add("sist");
        System.out.println(l);
    }
}
