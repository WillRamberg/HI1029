package com.example.hi1029.F8;

import java.util.Arrays;

public class NB26_3<K, V> {

    public static void main(String[] args) {
        NB26_3<Integer, Integer> map = new NB26_3<>(10);
        for(int i = 0; i< 4; i++){
            map.put(i,i+1);
        }
        System.out.println(map);
    }

    private static class KeyValue<K, V> {
        K key;
        V value;

        public KeyValue(K key,V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " - " + value;
        }
    }

    private KeyValue<K, V>[] table;
    private int nrOfEntries;

    public NB26_3(int initialSize){
        table = new KeyValue[initialSize];
        nrOfEntries = 0;
    }

    public V get(K key){
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        while(table[index] != null && (table[index].key == null || !table[index].key.equals(key))){
            index++;
            index %= table.length;
        }
        if(table[index] == null)
            return null;

        return table[index].value;
    }

    public V put(K key, V value){
        int index = key.hashCode() % table.length;
        if(index < 0) index += table.length;

        if(get(key) != null) {
            table[index].value = value;
            return value;
        }

        nrOfEntries++;

        if(nrOfEntries > (0.75 * table.length))
            rehash(table.length*2);

        while(table[index] != null && (table[index].key == null || !table[index].key.equals(key))){
            index++;
            index %= table.length;
        }
        table[index] = new KeyValue<>(key, value);
        return value;
    }

    private void rehash(int newSize){
        KeyValue<K, V>[] oldArray = table.clone();
        table = new KeyValue[newSize];
        for (KeyValue<K, V> curr : oldArray) {
            if(curr != null && curr.value != null)
                this.put(curr.key, curr.value);
        }
        oldArray = null;
    }

    private V remove(K key){
        int index = key.hashCode() % table.length;
        if(index < 0)
            index += table.length;

        while(table[index] != null && (table[index].key == null || !table[index].key.equals(key))){
            index++;
            index %= table.length;
        }

        if(table[index] == null)
            return null;

        V oldValue = table[index].value;
        table[index].value = null;
        table[index].key = null;
        return oldValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                sb.append("Index ").append(i).append(": ").append(table[i].toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
