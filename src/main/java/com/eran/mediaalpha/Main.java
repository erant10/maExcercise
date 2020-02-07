package com.eran.mediaalpha;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParenthesesUtil parenthesesUtil = new ParenthesesUtil();

        Scanner in = new Scanner(System.in);
        String expression;
        while (!(expression = awaitInput(in)).equals("exit")) {
            try {
                System.out.println(parenthesesUtil.removeRedundanctParentheses(expression));
            } catch (Exception e) {
                System.out.println(String.format("An error occurred: %s", e));
            }
        }
    }

    private static String awaitInput(Scanner in) {
        System.out.println("Please enter an expression:");
        return in.nextLine();
    }
}
