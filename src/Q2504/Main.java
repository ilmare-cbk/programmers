package Q2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호의 값
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parenthesis = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        for (String p : parenthesis) {
            if (stack.isEmpty()) {
                stack.push(p);
            } else {
                if (p.equals("(") || p.equals("[")) {
                    stack.push(p);
                } else {
                    int temp = 0;
                    int multiplier = p.equals(")") ? 2 : 3;
                    boolean flag = false;
                    while (!stack.isEmpty()) {
                        String pop = stack.pop();
                        if ((pop.equals("(") && p.equals(")")) || (pop.equals("[") && p.equals("]"))) {
                            flag = true;
                            if (temp == 0) {
                                stack.push(String.valueOf(multiplier));
                            } else {
                                stack.push(String.valueOf(temp * multiplier));
                            }
                            break;
                        } else if (!pop.equals("(") && !pop.equals("[") && !pop.equals(")") && !pop.equals("]")) { // 숫자인 경우
                            temp += Integer.parseInt(pop);
                        } else {
                            System.out.println(0);
                            return;
                        }
                    }
                    if (!flag) {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (pop.equals("(") || pop.equals("[") || pop.equals(")") || pop.equals("]")) {
                System.out.println(0);
                return;
            } else sum += Integer.parseInt(pop);
        }

        System.out.println(sum);
    }
}
