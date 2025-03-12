package Q15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * N과 M (9)
 */
public class Main {
    private static int N;
    private static int M;
    private static StringBuilder sb = new StringBuilder();
    private static Map<Integer, Integer> count = new HashMap<>();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        String[] numbers = br.readLine().split(" ");
        for (String number : numbers) {
            queue.add(Integer.parseInt(number));
        }
        int i = 0;
        arr = new int[N];
        while (!queue.isEmpty()) {
            Integer number = queue.poll();
            if (count.get(number) == null) {
                arr[i++] = number;
            }
            count.put(number, count.getOrDefault(number, 0) + 1);
        }

        search(0, "");

        System.out.println(sb);
    }

    private static void search(int length, String s) {
        if (length == M) {
            sb.append(s).append(System.lineSeparator());
            return;
        }

        for (int i = 0; i < count.size(); i++) {
            Integer cnt = count.get(arr[i]);
            if (cnt != 0) {
                count.put(arr[i], cnt - 1);
                search(length + 1, s + arr[i] + " ");
                count.put(arr[i], count.get(arr[i]) + 1);
            }
        }
    }
}
