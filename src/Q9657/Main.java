package Q9657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 돌 게임 3
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (i >= 1) dp[i] = true;
            if (i >= 2) dp[i] = !dp[i - 1];
            if (i >= 3) dp[i] = dp[i] || !dp[i - 3];
            if (i >= 4) dp[i] = dp[i] || !dp[i - 4];
        }

        System.out.println(dp[N] ? "SK" : "CY");
    }
}
