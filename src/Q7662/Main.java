package Q7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 이중 우선순위 큐
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Integer, Integer> count = new HashMap<>();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                String[] command = br.readLine().split(" ");
                int num = Integer.parseInt(command[1]);
                if (command[0].equals("I")) {
                    min.offer(num);
                    max.offer(num);
                    count.put(num, count.getOrDefault(num, 0) + 1);
                } else {
                    if (command[1].equals("1")) {
                        remove(max, count);
                    } else {
                        remove(min, count);
                    }
                }
            }
            if (count.isEmpty()) {
                sb.append("EMPTY").append(System.lineSeparator());
            } else {
                sb.append(find(max, count)).append(" ")
                        .append(find(min, count)).append(System.lineSeparator());
            }
        }

        System.out.println(sb);
    }

    private static void remove(PriorityQueue<Integer> queue, Map<Integer, Integer> count) {
        if (count.isEmpty()) {
            return;
        }

        while (!queue.isEmpty()) {
            Integer number = queue.poll();
            if (count.get(number) != null) {
                count.put(number, count.get(number) - 1);
                if (count.get(number) == 0) {
                    count.remove(number);
                }
                return;
            }
        }
    }

    private static int find(PriorityQueue<Integer> queue, Map<Integer, Integer> count) {
        int num = 0;
        while (!queue.isEmpty()) {
            Integer number = queue.poll();
            if (count.get(number) != null) {
                num = number;
                break;
            }
        }
        return num;
    }
}
