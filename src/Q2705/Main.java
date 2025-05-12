package Q2705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬 파티션
 */
public class Main {
    private static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = dp[3] = 2;
        for (int i = 4; i <= 1000; i++) {
            if (i % 2 == 0) dp[i] = dp[i / 2] + dp[i - 2];
            else dp[i] = dp[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
