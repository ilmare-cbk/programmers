package Q1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 숨바꼭질
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        boolean[] visited = new boolean[100001];
        Integer[] depth = new Integer[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        depth[N] = 0;
        visited[N] = true;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();

            if (x == K) {
                break;
            }

            // X - 1
            if (x - 1 >= 0 && !visited[x - 1]) {
                visited[x - 1] = true;
                queue.offer(x - 1);
                depth[x - 1] = depth[x] + 1;
            }

            // X + 1
            if (x + 1 <= 100000 && !visited[x + 1]) {                visited[x + 1] = true;
                queue.offer(x + 1);
                depth[x + 1] = depth[x] + 1;
            }

            // 2 * X
            if (2 * x <= 100000 && !visited[2 * x]) {
                visited[2 * x] = true;
                queue.offer(2 * x);
                depth[2 * x] = depth[x] + 1;
            }
        }

        System.out.println(depth[K]);
    }
}
