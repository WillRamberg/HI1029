package com.example.hi1029.F4;

import java.util.Stack;

public class NB7 {
    public static int evaluateInfix(String expression) {
        String postfixExpression = infixToPostfix(expression);
        int result = evaluatePostfix(postfixExpression);
        return result;
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    private static String infixToPostfix(String expression) {
        StringBuilder postfixResult = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfixResult.append(ch);
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfixResult.append(operatorStack.pop());
                }
                operatorStack.pop();
            } else if (isOperator(ch)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(ch)) {
                    postfixResult.append(operatorStack.pop());
                }
                operatorStack.push(ch);
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixResult.append(operatorStack.pop());
        }
        return postfixResult.toString();
    }

    private static int evaluatePostfix(String postfixExpression) {
        Stack<Integer> operandStack = new Stack<>();

        for (char ch : postfixExpression.toCharArray()) {
            if (Character.isDigit(ch)) {
                operandStack.push(Character.getNumericValue(ch));
            } else if (isOperator(ch)) {
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                int result;
                switch (ch) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }
                operandStack.push(result);
            }
        }
        return operandStack.pop();
    }

    public static void main(String[] args) {
        String infixExpression = "(3 + 7) * 2 - 9";
        System.out.println("This is the PostFix expression: " + infixToPostfix(infixExpression));
        int result = evaluateInfix(infixExpression);
        System.out.println("The result of the infix expression '" + infixExpression + "' is: " + result);
    }
}