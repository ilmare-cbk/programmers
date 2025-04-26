package Q17291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 새끼치기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            if (i <= 3) dp[i] = dp[i - 1] * 2;
            else if (i == 4) dp[i] = dp[i - 1] * 2 - 1;
            else {
                if (i % 2 == 0) dp[i] = dp[i - 1] * 2 - dp[i - 4] - dp[i - 5];
                else dp[i] = dp[i - 1] * 2;
            }
        }

        System.out.println(dp[N]);
    }
}