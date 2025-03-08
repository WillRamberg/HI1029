package com.example.hi1029.Tenta.T2106.upg5;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        for (int i = 0; i < 7; i++)
        {
            list.add("e" + i);
        }
        //uppgift 5a
        for(String d:list)
        {
            System.out.println(d);
        }
        //uppgift 5b
        Iterator<String> iter = list.iterator(3);
        while(iter.hasNext())
            System.out.println(iter.next());
    }

}
