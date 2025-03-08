package com.example.hi1029.Tenta.T2103.upg3;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        for(int i=0;i<4;i++)
            list.add(0,"e"+(7-i));
        System.out.println(list.get(2));
        System.out.println(list);
        for(int i=0;i<4;i++)
            list.add(i,"e"+i);
        System.out.println(list);
        System.out.println(list.get(5)+":"+list.size());
    }
}
