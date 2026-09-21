package ru.KennyHuso.Lab1_1;
import java.util.Stack;

public class Main {
    static boolean check(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(')');
                case '[' -> stack.push(']');
                case '{' -> stack.push('}');
                default -> {
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    static void main() {
        System.out.println("[]: " + check("[]"));                 // true
        System.out.println("[](){} " + check("[](){}"));          // true
        System.out.println("[({})]: " + check("[({})]"));         // true
        System.out.println("[({}()){}]: " + check("[({}()){}]")); // true
        System.out.println("{]: " + check("{]"));                 // false
        System.out.println("({)}: " + check("({)}"));             // false
    }
}