package com.example.hi1029.F1;

import java.util.Arrays;

public class NArrayList<E>{
    private E[] data;
    private int nrElements;
    private int maxSize;
    public NArrayList(){
        nrElements = 0;
        maxSize = 10;
        data = (E[]) new Object[maxSize];
    }

    public boolean add(E element){
        if(nrElements == maxSize) {
            reallocate();
        }
        data[nrElements] = element;
        nrElements++;
        return true;
    }

    public void add(E element, int index) {
        if (0 <= index && index <= nrElements) {
            if (nrElements == maxSize)
                reallocate();
            for (int i = nrElements; i > index; i--)
                data[i] = data[i - 1];
            data[index] = element;
            nrElements++;
            return;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

        public E get(int index){
        if(0 < index && index <= nrElements)
            return data[index];
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public boolean remove(int index){
        if(0 <= index && index < nrElements){
            for(int i = index; i < nrElements-1; i++){
                data[i] = data[i+1];
            }
            nrElements--;
            return true;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    private void reallocate(){
        maxSize = maxSize * 2;
        data = Arrays.copyOf(data, maxSize);
    }

    public E set(E element, int index){
        E tmp;
        if(0 <= index && index < nrElements){
            tmp = data[index];
            data[index] = element;
            return tmp;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public int indexOf(E element){
        for(int i = 0; i < nrElements; i++){
            if(data[i] == element) return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nrElements; i++){
            sb.append(data[i]).append(", ");
        }
        return sb.toString();
    }
}
