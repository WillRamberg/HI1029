package com.example.hi1029.F10;

import java.util.Arrays;

public class NB30<E extends Comparable<E>> {

    private int size;
    private E[] data;
    private int nextPos;

    public NB30(int size){
        this.size = size;
        data = (E[]) new Comparable[size];
        nextPos = 0;
    }

    public boolean insert(E item){
        if(nextPos == data.length)
            resize();

        data[nextPos] = item;
        heapUp(nextPos);
        nextPos++;

        return true;
    }

    private void heapUp(int child){
        if(child <= 0)
            return;
        int parent = (child - 1) / 2;

        if(data[child].compareTo(data[parent]) < 0){
            E tmp = data[child];
            data[child] = data[parent];
            data[parent] = tmp;
            heapUp(parent);
        }
    }

    private void resize(){
        int newSize = data.length * 2;
        Arrays.copyOf(data, newSize);
    }


    public E extract(){
        if(nextPos == 0)
            return null;

        nextPos--;
        E tmp = data[0];
        data[0] = data[nextPos];
        data[nextPos] = null;

        heapDown(0);
        return tmp;
    }

    public void heapDown(int parent){
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;
        int minIndex = parent;

        if(leftChild < nextPos && data[leftChild].compareTo(data[minIndex]) < 0)
            minIndex = leftChild;

        if(rightChild < nextPos && data[rightChild].compareTo(data[minIndex]) < 0)
            minIndex = rightChild;

        if(minIndex != parent){
            E tmp = data[minIndex];
            data[minIndex] = data[parent];
            data[parent] = tmp;
            heapDown(minIndex);
        }
    }

}
