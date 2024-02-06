package com.example.hi1029.F4.NB7_2;

import java.util.EmptyStackException;
import java.util.Stack;

public class NB7_2 {
    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }

    public static int eval(String expression) throws SyntaxErrorException {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();
        String[] tokens = expression.split(" +");  // Split by whitespace

        try {
            for (String nextToken : tokens) {
                char firstChar = nextToken.charAt(0);
                if (Character.isDigit(firstChar)) {
                    operandStack.push(Integer.parseInt(nextToken));
                } else if (isOperator(firstChar)) {
                    processOperator(firstChar);
                } else if (firstChar == '(') {
                    operatorStack.push(firstChar);
                } else if (firstChar == ')') {
                    processParenthesis();
                } else {
                    throw new SyntaxErrorException("Invalid character encountered: " + firstChar);
                }
            }

            while (!operatorStack.empty()) {
                char op = operatorStack.pop();
                if (op == '(') {
                    throw new SyntaxErrorException("Unmatched opening parenthesis");
                }
                operandStack.push(evalOp(op));
            }

            if (operandStack.size() == 1) {
                return operandStack.pop();
            } else {
                throw new SyntaxErrorException("Syntax Error: Too many operands");
            }
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }

    private static final String OPERATORS = "+-*/";
    private static Stack<Integer> operandStack;
    private static Stack<Character> operatorStack;

    private static void processOperator(char op) {
        while (!operatorStack.empty() && operatorStack.peek() != '(' &&
                precedence(operatorStack.peek()) >= precedence(op)) {
            operandStack.push(evalOp(operatorStack.pop()));
        }
        operatorStack.push(op);
    }

    private static void processParenthesis() throws SyntaxErrorException {
        while (!operatorStack.empty() && operatorStack.peek() != '(') {
            operandStack.push(evalOp(operatorStack.pop()));
        }
        if (operatorStack.empty()) {
            throw new SyntaxErrorException("Unmatched closing parenthesis");
        }
        operatorStack.pop(); // Pop the '('
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    private static int evalOp(char op) {
        int rhs = operandStack.pop();
        int lhs = operandStack.pop();

        switch (op) {
            case '+':
                return lhs + rhs;
            case '-':
                return lhs - rhs;
            case '*':
                return lhs * rhs;
            case '/':
                return lhs / rhs;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    private static boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }
}