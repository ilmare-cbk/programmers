package Q11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 행렬 곱셈 순서
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] M = new int[N + 1][2];
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M[i + 1][0] = Integer.parseInt(st.nextToken());
            M[i + 1][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i != j) dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int gap = 1; gap < N; gap++) {
            for (int i = 1; i <= N - gap; i++) {
                int j = i + gap;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + M[i][0] * M[k][1] * M[j][1]);
                }
            }
        }
        System.out.println(dp[1][N]);
    }
}
