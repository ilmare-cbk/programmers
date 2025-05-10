package Q15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 퇴사 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            if (T[i] + i - 1 <= N) {
                dp[i] = P[i];
                if (T[i] + i <= N) {
                    dp[i] += dp[T[i] + i];
                }
            }
            if (i < N) {
                dp[i] = Math.max(dp[i], dp[i + 1]);
            }
        }

        System.out.println(dp[1]);
    }
}
