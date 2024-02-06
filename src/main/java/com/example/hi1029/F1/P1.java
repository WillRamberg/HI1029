package com.example.hi1029.F1;

import java.util.ArrayList;
import java.util.Arrays;

public class P1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("William");
        list.add("Patrik");
        list.add("Aisha");
        list.add("William");
        list.add("Alicia");
        System.out.println(list);
        replace(list, "William", "Lucas");
        System.out.println(list);
        delete(list, "Lucas");
        System.out.println(list);
    }
    public static void replace(ArrayList<String> alist , String olditem , String newltem){
        for(int i = 0; i < alist.size(); i++){
            if(alist.get(i).equals(olditem)){
                alist.set(i, newltem);
            }
        }
    }

    public static void delete(ArrayList<String> alist, String target){
        for(int i = 0; i < alist.size(); i++){
            if(alist.get(i).equals(target)){
                alist.remove(i);
                return;
            }
        }
    }

}
