package Q11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이항 계수 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][N + 1];

        dp[0][0] = dp[1][0] = dp[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10_007;
            }
        }

        System.out.println(dp[N][K] % 10_007);
    }
}
