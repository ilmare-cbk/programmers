package Q1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 후위 표기식
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = br.readLine().split("");
        Stack<String> operators = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (String s : commands) {
            char c = s.charAt(0);
            if (c >= 65 && c <= 90) {
                sb.append(s);
            } else {
                if (operators.isEmpty()) {
                    operators.push(s);
                } else {
                    if (c == '(') {
                        operators.push(s);
                    }
                    if (c == ')') {
                        String operator = operators.peek();
                        while (!operator.equals("(")) {
                            sb.append(operators.pop());
                            operator = operators.peek();
                        }
                        operators.pop();
                    }
                    if (c == '+' || c == '-') {
                        String operator = operators.peek();
                        while (!operator.equals("(")) {
                            sb.append(operators.pop());
                            if (operators.isEmpty()) {
                                break;
                            }
                            operator = operators.peek();
                        }
                        operators.push(s);
                    }
                    if (c == '*' || c == '/') {
                        String operator = operators.peek();
                        while (operator.equals("*") || operator.equals("/")) {
                            sb.append(operators.pop());
                            if (operators.isEmpty()) {
                                break;
                            }
                            operator = operators.peek();
                        }
                        operators.push(s);
                    }
                }
            }
        }
        while (!operators.isEmpty()) {
            sb.append(operators.pop());
        }
        System.out.println(sb);
    }
}
