package 덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> dq = new LinkedList<>();
        while (N > 0) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push_back")) {
                dq.addFirst(Integer.parseInt(input[1]));
            } else if (input[0].equals("push_front")) {
                dq.addLast(Integer.parseInt(input[1]));
            } else if (input[0].equals("front")) {
                sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append(System.lineSeparator());
            } else if (input[0].equals("back")) {
                sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append(System.lineSeparator());
            } else if (input[0].equals("size")) {
                sb.append(dq.size()).append(System.lineSeparator());
            } else if (input[0].equals("empty")) {
                sb.append(dq.isEmpty() ? 1 : 0).append(System.lineSeparator());
            } else if (input[0].equals("pop_front")) {
                sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append(System.lineSeparator());
            } else if (input[0].equals("pop_back")) {
                sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append(System.lineSeparator());
            }
            N--;
        }
        System.out.println(sb);
    }
}
