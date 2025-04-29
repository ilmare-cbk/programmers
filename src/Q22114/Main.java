package Q22114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 창영이와 점프
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] L = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[2][N + 1];
        dp[0][1] = dp[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            if (L[i - 1] <= K) {
                dp[0][i] = dp[0][i - 1] + 1;
                dp[1][i] = dp[1][i - 1] + 1;
            } else {
                dp[0][i] = 1;
                dp[1][i] = dp[0][i - 1] + 1;
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[1][i]);
        }

        System.out.println(max);
    }
}
