package Q14916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 거스름돈
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            dp[i + 1] = Integer.MAX_VALUE;
        }

        if (n >= 2) dp[2] = 1;
        if (n >= 4) dp[4] = dp[2] + 1;
        if (n >= 5) dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }

        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }
}
