package 큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                q.push(Integer.parseInt(input[1]));
            } else if (input[0].equals("front")) {
                sb.append(q.isEmpty() ? -1 : q.peekLast()).append(System.lineSeparator());
            } else if (input[0].equals("back")) {
                sb.append(q.isEmpty() ? -1 : q.peekFirst()).append(System.lineSeparator());
            } else if (input[0].equals("size")) {
                sb.append(q.size()).append(System.lineSeparator());
            } else if (input[0].equals("empty")) {
                sb.append(q.isEmpty() ? 1 : 0).append(System.lineSeparator());
            } else {
                sb.append(q.isEmpty() ? -1 : q.pollLast()).append(System.lineSeparator());
            }
            N--;
        }
        System.out.println(sb);
    }
}
