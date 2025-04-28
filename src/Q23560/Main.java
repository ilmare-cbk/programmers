package Q23560;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        if (N >= 1) dp[1] = 2;
        if (N >= 2) dp[2] = 6;

        int sum = 0;
        for (int i = 3; i <= N; i++) {
            sum += dp[i - 2];
            dp[i] = 2 * (dp[i - 1] + sum + 1);
        }

        System.out.println(dp[N]);
    }
}
