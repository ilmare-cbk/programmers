package Q14494;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다이나믹이 뭐예요?
 */
public class Main {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n + 1][m + 1];
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 || j == 1) dp[i][j] = 1;
                else dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        System.out.println(dp[n][m]);
    }
}