package Q1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 그림 교환
 */
public class Main {
//    private static int N;
//    private static int[][] cost;
//    private static int[][] dp;
//    private static int answer = 1;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        cost = new int[N][N];
//        dp = new int[1 << N][N];
//
//        for (int i = 0; i < N; i++) {
//            String[] data = br.readLine().split("");
//            for (int j = 0; j < N; j++) {
//                cost[i][j] = Integer.parseInt(data[j]);
//            }
//        }
//
//        dp[1][0] = 1;
//        exchange(1, 0, 0);
//        System.out.println(answer);
//    }
//
//    private static void exchange(int state, int owner, int lastPrice) {
//        for (int i = 0; i < N; i++) {
//            if ((state & (1 << i)) != 0) continue; // 이미 그림을 소유했던 사람은 패스
//
//            int price = cost[owner][i];
//            if (price < lastPrice) continue; // 이전에 산 가격보다 작으면 패스
//
//            int nextState = state | (1 << i);
//            if (dp[nextState][i] <= dp[state][owner] + 1) {
//                dp[nextState][i] = dp[state][owner] + 1;
//                answer = Math.max(answer, dp[nextState][i]);
//                exchange(nextState, i, price);
//            }
//        }
//    }

    private static int N;
    private static int[][] cost;
    private static int[][][] dp; // mask | owner | lastPrice
    private static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(data[j]);
            }
        }

        dp = new int[1 << N][N][10];
        dp[1][0][0] = 1;

        for (int mask = 1; mask < (1 << N); mask++) {
            for (int u = 0; u < N; u++) {
                for (int p = 0; p < 10; p++) {
                    if (dp[mask][u][p] == 0) continue;

                    for (int v = 0; v < N; v++) {
                        if ((mask & (1 << v)) != 0) continue; // 이미 소유한 사람은 패스
                        int price = cost[u][v];
                        if (price < p) continue; // 이전 가격보다 작으면 패스

                        int nextMask = mask | (1 << v);
                        if (dp[nextMask][v][price] < dp[mask][u][p] + 1) {
                            dp[nextMask][v][price] = dp[mask][u][p] + 1;
                            answer = Math.max(answer, dp[nextMask][v][price]);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
