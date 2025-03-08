package com.example.hi1029.Tenta.T2303.upg3;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkBrackets("(()()(()())((())))()"));
        System.out.println(checkBrackets("(((){}[])[]{()}){}"));
        System.out.println(checkBrackets("[{}([]{})]"));
        System.out.println(checkBrackets("({)}"));
        System.out.println(checkBrackets("())"));
        System.out.println(checkBrackets("[[]"));
        System.out.println(checkBrackets("{[]([(){]}}"));
    }

    private static boolean checkBrackets(String s) {
        Stack<Character> openStack = new Stack<>();
        Stack<Character> closedStack = new Stack<>();

        char[] string = s.toCharArray();

        for (int i = 0; i < string.length; i++) {
            if (string[i] == '(' || string[i] == '{' || string[i] == '[') {
                openStack.push(string[i]);
            }
            if(string[i] == ')' || string[i] == '}' || string[i] == ']') {
                closedStack.push(string[i]);
                if(openStack.isEmpty() || !compare(openStack.pop(),closedStack.pop()))
                    return false;
            }
        }
        if(openStack.isEmpty() && closedStack.isEmpty())
            return true;
        return false;
    }

    private static boolean compare(Character open, Character close) {
        if(open == '(' && close == ')')
            return true;
        if(open == '{' && close == '}')
            return true;
        if(open == '[' && close == ']')
            return true;
        return false;
    }
}
