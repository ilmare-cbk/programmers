package Q17271;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 리그 오브 레전설 (Small)
 */
public class Main {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            if (i > M) dp[i] = (dp[i - 1] + dp[i - M]) % MOD;
            else if (i == M) dp[i] = (dp[i - 1] + 1) % MOD;
            else dp[i] = dp[i - 1];
        }

        System.out.println(dp[N]);
    }
}
