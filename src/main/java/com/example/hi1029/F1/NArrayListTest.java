package com.example.hi1029.F1;

public class NArrayListTest {


    public static void main(String[] args) {
        NArrayList<String> list = new NArrayList<>();

        list.add("William");
        list.add("Patrik");
        list.add("Aisha");
        list.add("Alicia");
        list.add("Celina", 2);
        System.out.println(list);

        list.remove(0);
        list.set("Lucas", 3);
        System.out.println(list);
        System.out.println(list.indexOf("Patrik"));
        System.out.println(list.get(3));
    }



}

