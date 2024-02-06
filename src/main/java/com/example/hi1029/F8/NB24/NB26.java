package com.example.hi1029.F8.NB24;


import com.example.hi1029.Labb1.U3.LinkedList;

import java.lang.reflect.Field;
public class NB26 {
    public static void main(String[] args) {
        HashTableBucket<Integer, String> hashTable = new HashTableBucket<>(10);

        // Populate the hash table with entries
        for (int i = 0; i < 40; i++) {
            hashTable.put(i, "str-" + i);
        }

        // Print the original hash table
        System.out.println("Original Hash Table:");
        System.out.println(hashTable);

        // Test retrieval of values
        System.out.println("Testing get method:");
        for (int i = 0; i < 40; i++) {
            String value = hashTable.get(i);
            System.out.println("Key: " + i + ", Value: " + value);
        }

        // Test removal of entries
        System.out.println("\nTesting remove method:");
        hashTable.remove(5);
        hashTable.remove(35);
        hashTable.remove(17);

        // Print the hash table after removal
        System.out.println("Hash Table after removal:");
        System.out.println(hashTable);

        // Test retrieval of values after removal
        System.out.println("Testing get method after removal:");
        System.out.println("Value for key 32: " + hashTable.get(32));
        System.out.println("Value for key 35: " + hashTable.get(35));

        // Test updating values
        System.out.println("\nTesting put method (update values):");
        hashTable.put(10, "UpdatedValue-10");
        hashTable.put(20, "UpdatedValue-20");

        // Print the hash table after updating values
        System.out.println("Hash Table after updating values:");
        System.out.println(hashTable);

        // Print the hash table after resizing
        System.out.println("Hash Table after resizing:");
        System.out.println(hashTable);
    }
}