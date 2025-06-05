package Q1562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단 수
 */
public class Main {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N + 1][10][1 << 10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int digit = 0; digit <= 9; digit++) {
                for (int mask = 0; mask < 1024; mask++) {
                    if (digit > 0) {
                        dp[len][digit][mask | (1 << digit)] =
                                (dp[len][digit][mask | (1 << digit)] + dp[len - 1][digit - 1][mask]) % MOD;
                    }
                    if (digit < 9) {
                        dp[len][digit][mask | (1 << digit)] =
                                (dp[len][digit][mask | (1 << digit)] + dp[len - 1][digit + 1][mask]) % MOD;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[N][i][1023]) % MOD;
        }
        System.out.println(result);
    }
}
