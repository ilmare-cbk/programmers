package Q5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * AC
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            String[] data = arr.substring(1, arr.length() - 1).split(",");

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                deque.offer(Integer.parseInt(data[i]));
            }

            String answer = "";
            boolean direction = true; // true면 순방향
            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    direction = !direction;
                } else if (c == 'D' && deque.isEmpty()) {
                    answer = "error";
                    break;

                } else {
                    if (direction) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (answer.equals("error")) {
                sb.append("error").append(System.lineSeparator());
            } else {
                sb.append("[");
                int length = deque.size();
                for (int i = 0; i < length; i++) {
                    if (direction) {
                        if (i == length - 1) {
                            sb.append(deque.pollFirst());
                        } else {
                            sb.append(deque.pollFirst()).append(",");
                        }
                    } else {
                        if (i == length - 1) {
                            sb.append(deque.pollLast());
                        } else {
                            sb.append(deque.pollLast()).append(",");
                        }
                    }
                }
                sb.append("]").append(System.lineSeparator());
            }
        }
        System.out.println(sb);
    }
}
