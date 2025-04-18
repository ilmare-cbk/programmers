package Q14606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피자 (Small)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        if (N >= 1) dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = i / 2 * (i - i / 2) + dp[i / 2] + dp[i - i / 2];
        }

        System.out.println(dp[N]);
    }
}
