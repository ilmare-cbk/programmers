package Q1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * ACM Craft
 */
public class Main {
    private static int[] delay;
    private static List<Integer>[] graph;
    private static int[] degree;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            graph = new List[N + 1];
            degree = new int[N + 1];
            dp = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            delay = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                delay[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int b1 = Integer.parseInt(st.nextToken());
                int b2 = Integer.parseInt(st.nextToken());
                graph[b1].add(b2);
                degree[b2]++;
            }
            int W = Integer.parseInt(br.readLine());
            calculate();
            sb.append(dp[W]).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static void calculate() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                dp[i] = delay[i];
            }
        }

        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            for (Integer i : graph[node]) {
                degree[i]--;
                dp[i] = Math.max(dp[i], dp[node] + delay[i]);
                if (degree[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }
}
/*
1
5 10
100000 99999 99997 99994 99990
4 5
3 5
3 4
2 5
2 4
2 3
1 5
1 4
1 3
1 2
4
 */