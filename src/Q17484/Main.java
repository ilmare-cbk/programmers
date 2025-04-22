package Q17484;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 진우의 달 여행 (Small)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        int[][][] dp = new int[N + 2][M + 2][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <= N + 1; i++) {
            for (int j = 0; j <= M + 1; j++) {
                if (i == 0 || j == 0 || j == M + 1) dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = 1000;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i == 1) {
                    dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = map[i][j];
                } else {
                    // 좌하향
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];

                    // 하향
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];

                    // 우하향
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + map[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= M; j++) {
            int tmp = Math.min(dp[N][j][2], Math.min(dp[N][j][0], dp[N][j][1]));
            min = Math.min(min, tmp);
        }

        System.out.println(min);
    }
}
