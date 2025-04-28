package Q18249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 욱제가 풀어야 하는 문제
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[191230];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= 191229; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007;
        }

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
