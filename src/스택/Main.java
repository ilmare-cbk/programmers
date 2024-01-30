package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final String PUSH = "push";
    private static final String TOP = "top";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String POP = "pop";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case PUSH:
                    stack.push(Integer.parseInt(command[1]));
                    break;
                case TOP:
                    if (stack.isEmpty()) {
                        sb.append(-1).append(System.lineSeparator());
                    } else {
                        sb.append(stack.peek()).append(System.lineSeparator());
                    }
                    break;
                case SIZE:
                    sb.append(stack.size()).append(System.lineSeparator());
                    break;
                case EMPTY:
                    if (stack.isEmpty()) {
                        sb.append(1).append(System.lineSeparator());
                    } else {
                        sb.append(0).append(System.lineSeparator());
                    }
                    break;
                case POP:
                    if (stack.isEmpty()) {
                        sb.append(-1).append(System.lineSeparator());
                    } else {
                        sb.append(stack.pop()).append(System.lineSeparator());
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
