package com.example.hi1029.Tenta.T2406.upg3;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        for (int i = 0; i <= 4; i++)
        {
            list.add("e" + i);
        }
        //uppgift 1a
        for(String d:list)
        {
            System.out.println(d);
        }
        //uppgift 1b
        Iterator<String> iter = list.iterator(2);
        while(iter.hasNext())
            System.out.println(iter.next());
    }

}
