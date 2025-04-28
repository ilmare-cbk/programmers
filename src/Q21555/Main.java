package Q21555;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 빛의 돌 옮기기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];
        int[] B = new int[N + 1];
        long[][] dp = new long[2][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[0][i] = A[i];
                dp[1][i] = B[i];
            } else {
                dp[0][i] = Math.min(dp[0][i - 1] + A[i], dp[1][i - 1] + A[i] + K);
                dp[1][i] = Math.min(dp[1][i - 1] + B[i], dp[0][i - 1] + B[i] + K);
            }
        }

        System.out.println(Math.min(dp[0][N], dp[1][N]));
    }
}
