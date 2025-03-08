package com.example.hi1029.Tenta.T2106.upg3;

public class Main {

    public static void main(String[] args) {
        IntQueue myQ = new IntQueue(2);
        for (int i = 0; i < 8; i++) {
            myQ.enqueue(i);
        }
        int i=0;
        while (!myQ.isEmpty()&&i<5) {
            i++;
            System.out.println(myQ.dequeue());
        }
        for (i = 8; i < 30; i++) {
            myQ.enqueue(i);
        }
        while (!myQ.isEmpty()) {
            System.out.println(myQ.dequeue());
        }
        myQ.dequeue();
    }

    public static class IntQueue{
        private int[] arr;
        private int size;

        public IntQueue(int size) {
            this.arr = new int[size];
            this.size = 0;
        }

        public void enqueue(int i){
            if(size == arr.length){
                int[] newArr = new int[arr.length*2];
                System.arraycopy(arr,0,newArr,0,arr.length);
                this.arr = newArr;
            }
            arr[size] = i;
            size++;
        }
        public int dequeue(){
            if(size == 0)
                throw new IllegalArgumentException("queue is empty");
            int tmp = arr[size-1];
            arr[size-1] = 0;
            size--;
            return tmp;
        }

        public boolean isEmpty(){
            return size == 0;
        }
    }

}
