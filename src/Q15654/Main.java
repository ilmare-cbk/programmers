package Q15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * N과 M (5)
 */
public class Main {
    private static int N;
    private static int M;
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    private static boolean[] visited;

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
        arr = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = queue.poll();
        }
        search(0, "");
        System.out.println(sb);
    }

    private static void search(int length, String s) {
        if (length == M) {
            sb.append(s).append(System.lineSeparator());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                search(length + 1, s + arr[i] + " ");
                visited[i] = false;
            }
        }
    }
}
