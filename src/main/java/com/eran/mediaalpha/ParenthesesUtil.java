package com.eran.mediaalpha;

import java.util.Arrays;
import java.util.List;

public class ParenthesesUtil {
    private List<Character> highPriorityOperators = Arrays.asList('*','/');
    private List<Character> lowPriorityOperators = Arrays.asList('+','-');

    public String removeRedundanctParentheses(String expression) {
        int leftIndex = expression.indexOf('(');
        int rightIndex = findClosingIndex(expression, leftIndex + 1);
        if (leftIndex < 0 && rightIndex < 0) {
            return expression;
        }
        if (leftIndex < 0 ^ rightIndex < 0) {
            throw new IllegalArgumentException("The expression is invalid. The number of left parentheses does not equal to the number of right parentheses");
        }
        String leftSide = expression.substring(0, leftIndex);
        String middle = expression.substring(leftIndex + 1, rightIndex);
        String rightSide = expression.substring(rightIndex + 1);
        String format = isParenthesesRequired(leftSide, middle, rightSide)? "%s(%s)%s" : "%s%s%s";
        return String.format(format, leftSide, removeRedundanctParentheses(middle), removeRedundanctParentheses(rightSide));
    }

    private int findClosingIndex(String expression, int startIndex) {
        int count = 1;
        int i;
        for(i = startIndex; i < expression.length() && count > 0; ++i) {
            if (expression.charAt(i) == '(')
                count ++;
            if (expression.charAt(i) == ')')
                count --;
        }
        return (count > 0)? -1 : i - 1;
    }

    private boolean isParenthesesRequired(String left, String middle, String right) {
        Character operatorToLeft = findOperator(left, false);
        Character operatorToRight = findOperator(right, true);
        return containsLowPriorityOperator(middle) &&
                (highPriorityOperators.contains(operatorToLeft) || highPriorityOperators.contains(operatorToRight));
    }

    private boolean containsLowPriorityOperator(String expression) {
        for (Character op: lowPriorityOperators) {
            if ((expression.indexOf(op) >= 0)) {
                return true;
            }
        }
        return false;
    }

    private Character findOperator(String expression, boolean leftToRight) {
        String trimmed = expression.trim();
        if (trimmed.isEmpty()) {
            return null;
        }
        int index = leftToRight? 0: trimmed.length() - 1;
        char character = expression.charAt(index);
        if (!lowPriorityOperators.contains(character) && !highPriorityOperators.contains(character)) {
            throw new IllegalArgumentException("The expression is invalid. The character immediately next to parentheses must be a valid operator");
        }
        return character;
    }
}