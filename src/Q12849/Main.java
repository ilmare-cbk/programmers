package Q12849;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 본대 산책
 */
public class Main {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] graph = {{1, 2}, {0, 2, 3}, {0, 1, 3, 4}, {1, 2, 4, 5}, {2, 3, 5, 6}, {3, 4, 7}, {4, 7}, {5, 6}};
        int D = Integer.parseInt(br.readLine());
        int[][] dp = new int[D + 1][8];
        for (int i = 1; i <= D; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1 && (j == 1 || j == 2)) {
                    dp[i][j] = 1;
                } else {
                    int sum = 0;
                    for (int node : graph[j]) {
                        sum = (sum + dp[i - 1][node]) % MOD;
                    }
                    dp[i][j] = sum;
                }
            }
        }
        System.out.println(dp[D][0]);
    }
}
