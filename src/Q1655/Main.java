package Q1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 가운데를 말해요
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (max.size() <= min.size()) {
                max.offer(num);
            } else {
                min.offer(num);
            }

            if (!min.isEmpty() && max.peek() > min.peek()) {
                int maxRoot = max.poll();
                int minRoot = min.poll();
                max.offer(minRoot);
                min.offer(maxRoot);
            }
            sb.append(max.peek()).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
