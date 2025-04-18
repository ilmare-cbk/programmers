package Q9655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 돌 게임
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // true : 상근, false : 창영
        boolean[] dp = new boolean[N + 1];
        if (N >= 1) dp[1] = true;
        if (N >= 2) dp[2] = false;
        if (N >= 3) dp[3] = true;

        for (int i = 4; i <= N; i++) {
            dp[i] = !dp[i - 1] || !dp[i - 3];
        }

        System.out.println(dp[N] ? "SK" : "CY");
    }
}
