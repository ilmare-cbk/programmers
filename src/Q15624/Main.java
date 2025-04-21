package Q15624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 수 7
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        int mod = 1_000_000_007;

        if (n >= 1) dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] % mod + dp[i - 2] % mod;
        }

        System.out.println(dp[n] % mod);
    }
}
