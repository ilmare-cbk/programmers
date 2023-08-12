package 괄호회전하기;

import java.util.Stack;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isCorrectable(s)) {
                answer++;
            }
            s = rotation(sb, s);
        }
        return answer;
    }

    private String rotation(StringBuilder sb, String s) {
        sb.setLength(0);
        return sb.append(s.substring(1))
                .append(s.charAt(0))
                .toString();
    }

    private boolean isCorrectable(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (isOpenBracket(s.charAt(i))) {
                stack.push(s.charAt(i));
                continue;
            }
            if (!stack.isEmpty() && isMatchingBracket(stack.peek(), s.charAt(i))) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpenBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isMatchingBracket(char before, char current) {
        return (before == '(' && current == ')') ||
                (before == '{' && current == '}') ||
                (before == '[' && current == ']');
    }
}
