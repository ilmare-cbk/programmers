package Q17404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * RGB거리 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];
        int INF = 1_000_001;
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) dp[1][j] = rgb[1][j];
                else dp[1][j] = INF;
            }

            for (int k = 2; k <= N; k++) {
                dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + rgb[k][0];
                dp[k][1] = Math.min(dp[k - 1][0], dp[k - 1][2]) + rgb[k][1];
                dp[k][2] = Math.min(dp[k - 1][0], dp[k - 1][1]) + rgb[k][2];
            }

            for (int j = 0; j < 3; j++) {
                if (i != j) answer = Math.min(answer, dp[N][j]);
            }
        }
        System.out.println(answer);
    }
}