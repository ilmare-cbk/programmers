package Q12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 숨바꼭질 2
 */
public class Main {
    private static final int MAX = 100_000;
    private static int N;
    private static int M;
    private static Queue<Integer> queue = new LinkedList<>();
    private static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[MAX + 1][2];
        for (int i = 0; i <= MAX; i++) {
            dist[i][0] = Integer.MAX_VALUE;
        }

        queue.add(N);
        dist[N][0] = 0; // 시간
        dist[N][1] = 1; // 방법의 수

        while (!queue.isEmpty()) {
            Integer n = queue.poll();

            if (n - 1 >= 0 && dist[n - 1][0] >= dist[n][0] + 1) {
                if (dist[n - 1][0] == dist[n][0] + 1) {
                    dist[n - 1][1]++;
                } else {
                    dist[n - 1][0] = dist[n][0] + 1;
                    dist[n - 1][1] = 1;
                }
                queue.add(n - 1);
            }

            if (n + 1 <= MAX && dist[n + 1][0] >= dist[n][0] + 1) {
                if (dist[n + 1][0] == dist[n][0] + 1) {
                    dist[n + 1][1]++;
                } else {
                    dist[n + 1][0] = dist[n][0] + 1;
                    dist[n + 1][1] = 1;
                }
                queue.add(n + 1);
            }

            if (2 * n <= MAX && dist[2 * n][0] >= dist[n][0] + 1) {
                if (dist[2 * n][0] == dist[n][0] + 1) {
                    dist[2 * n][1]++;
                } else {
                    dist[2 * n][0] = dist[n][0] + 1;
                    dist[2 * n][1] = 1;
                }
                queue.add(2 * n);
            }
        }
        System.out.println(dist[M][0]);
        System.out.println(dist[M][1]);
    }
}
