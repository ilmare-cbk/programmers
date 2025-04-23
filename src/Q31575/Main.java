package Q31575;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 도시와 비트코인
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        boolean[][] dp = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j]) {
                    dp[i][j] = false;
                } else {
                    if (i == 0 && j != 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (i != 0 && j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (i == 0) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }
                }
            }
        }
        System.out.println(dp[M - 1][N - 1] ? "Yes" : "No");
    }
}
