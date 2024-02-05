package 쇠막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int total = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.add('(');
                continue;
            }
            if (input.charAt(i) == ')') {
                stack.pop();
                if (isLaser(input, i)) {
                    total += stack.size();
                } else {
                    total += 1;
                }
            }

        }
        System.out.println(total);
    }

    private static boolean isLaser(String input, int i) {
        return input.charAt(i - 1) == '(' && input.charAt(i) == ')';
    }
}
