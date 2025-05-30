package Q16395;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 파스칼의 삼각형
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][n + 1];

        if (n >= 1) dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
