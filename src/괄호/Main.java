package 괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(T > 0) {
            for (String ps : br.readLine().split("")) {
                if (stack.isEmpty()) {
                    stack.push(ps);
                }
                else {
                    if (stack.peek().equals("(") && ps.equals(")")) {
                        stack.pop();
                    }
                    else {
                        stack.push(ps);
                    }
                }
            }
            if (stack.isEmpty()) {
                sb.append("YES").append(System.lineSeparator());
            }
            else {
                sb.append("NO").append(System.lineSeparator());
            }
            stack.clear();
            T--;
        }
        System.out.println(sb);
    }
}
