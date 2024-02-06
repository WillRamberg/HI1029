package com.example.hi1029.F8.NB24;

import com.example.hi1029.Labb1.U3.LinkedList;

import java.util.Iterator;

public class HashTableBucket<K, V> {
    private static class Entry<K, V> {
        public K key;
        public V value;
        public Entry(K k, V v) {
            key = k;
            value = v;
        }

        @Override
        public String toString() {
            return key + ": " + value;
        }
    }
    private LinkedList<Entry<K, V>>[] table;
    private int nrOfEntries;
    @SuppressWarnings("unchecked")
    public HashTableBucket(int initialSize) {
        table = new LinkedList[initialSize];
        nrOfEntries = 0;
    }
    public V get(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            return null;
        }
        for (Entry<K, V> e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        } else {
            V oldValue;
            for (Entry<K, V> e : table[index]) {
                if (e.key.equals(key)) {
                    oldValue = e.value;
                    e.value = value;
                    return oldValue;
                }
            }
        }
        table[index].add(0,new Entry<>(key, value));
        nrOfEntries++;
        if(nrOfEntries > (0.75 * table.length)) rehash(table.length*2);
        return value;
    }

    private void rehash(int newSize){
        LinkedList<Entry<K, V>>[] oldArray = table.clone();
        table = new LinkedList[newSize];

        for (int i = 0; i < oldArray.length; i++){
            if (oldArray[i] != null){
                for (Entry<K, V> curr : oldArray[i]) {
                    this.put(curr.key, curr.value);
                }
            }
        }
        oldArray = null;
    }

    public V remove(K key) {
        int index = key.hashCode() % table.length;
        if (index < 0) index += table.length;
        if (table[index] == null) return null;
        V oldvalue = null;
        Iterator<Entry<K, V>> iterator = table[index].iterator();
        while (iterator.hasNext()) {
            Entry<K, V> currentEntry = iterator.next();
            if (currentEntry.key.equals(key)) {
                oldvalue = currentEntry.value;
                iterator.remove();
            }
        }
        if (!table[index].iterator().hasNext())
            table[index] = null;
        return oldvalue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                sb.append("Hash Index: ").append(i).append("  ").append(table[i].toString()).append("\n");
            }
        }
        return sb.toString();
    }

}