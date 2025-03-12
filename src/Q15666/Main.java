package Q15666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * N과 M (12)
 */
public class Main {
    private static int N;
    private static int M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N];
        String[] numbers = br.readLine().split(" ");
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (String number : numbers) {
            queue.add(Integer.parseInt(number));
        }
        while (!queue.isEmpty()) {
            Integer number = queue.poll();
            if (cnt == 0) {
                arr[cnt++] = number;
            } else {
                if (arr[cnt - 1] != number) {
                    arr[cnt++] = number;
                }
            }
        }
        search(0, "", 0);
        System.out.println(sb);
    }

    private static void search(int length, String s, int prev) {
        if (length == M) {
            sb.append(s).append(System.lineSeparator());
            return;
        }

        for (int i = 0; i < cnt; i++) {
            if (arr[i] >= prev) {
                search(length + 1, s + arr[i] + " ", arr[i]);
            }
        }
    }
}
