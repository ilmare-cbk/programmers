package Q22871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 징검다리 건너기 (large)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stones = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }
        long[] dp = new long[N + 1];
        for (int j = 2; j <= N; j++) {
            for (int i = 1; i <= j - 1; i++) {
                if (i == 1) dp[j] = (long) (j - i) * (1 + Math.abs(stones[i] - stones[j]));
                else {
                    dp[j] = Math.min(dp[j], Math.max(dp[i], (long) (j - i) * (1 + Math.abs(stones[i] - stones[j]))));
                }
            }
        }
        System.out.println(dp[N]);
    }
}
