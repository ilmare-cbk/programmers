package Q31670;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 특별한 마법 공격
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] R = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            R[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[2][N + 1];

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[0][i] = 0;
                dp[1][i] = R[i];
            }
            else {
                dp[0][i] = dp[1][i - 1];
                dp[1][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + R[i];
            }
        }

        System.out.println(Math.min(dp[0][N], dp[1][N]));
    }
}
