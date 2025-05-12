package Q17391;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 무한부스터
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 600;
            }
        }
        dp[1][1] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = j; k <= Math.min(map[i][j] + j, M); k++) {
                    dp[i][k] = Math.min(dp[i][k], dp[i][j] + 1);
                }
                for (int k = i; k <= Math.min(map[i][j] + i, N); k++) {
                    dp[k][j] = Math.min(dp[k][j], dp[i][j] + 1);
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}
