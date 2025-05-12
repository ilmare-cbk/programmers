package Q22342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 계산 로봇
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] D = new int[M + 1][N + 1];
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                D[i][j] = line.charAt(j - 1) - '0';
            }
        }

        for (int j = 2; j <= N; j++) {
            for (int i = 1; i <= M; i++) {
                int max = dp[i][j - 1] + D[i][j - 1];
                if (i > 1) max = Math.max(max, dp[i - 1][j - 1] + D[i - 1][j - 1]);
                if (i < M) max = Math.max(max, dp[i + 1][j - 1] + D[i + 1][j - 1]);
                dp[i][j] = max;
            }
        }

        int max = 0;
        for (int i = 1; i <= M; i++) {
            max = Math.max(max, dp[i][N]);
        }

        System.out.println(max);
    }
}
