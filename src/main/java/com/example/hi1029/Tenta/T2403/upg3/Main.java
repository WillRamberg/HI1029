package com.example.hi1029.Tenta.T2403.upg3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack();
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        for(int i=0;i<5;i++)
            myStack.push("data: "+i);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.push("data 5"));
        while(!myStack.isEmpty())
            System.out.print(myStack.pop()+" ");
    }

    public static class Stack {
        public static class Node<String>{
            String data;
            Node<String> next;

            public Node(String data) {
                this.data = data;
                next = null;
            }
        }

        Node<String> top;

        public String peek(){
            if(top==null)
                return null;
            return top.data;
        }

        public boolean isEmpty(){
            return top == null;
        }

        public boolean push(String data){
            if(top == null){
                top = new Node(data);
                return true;
            }
            Node<String> node = new Node(data);
            node.next = top;
            top = node;
            return true;
        }

        public String pop(){
            if(top == null){
                return null;
            }
            String data = top.data;
            top= top.next;
            return data;
        }

    }
}
