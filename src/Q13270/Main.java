package Q13270;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 치킨
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        if (N >= 2) dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            if (i % 2 == 1) dp[i] = dp[i - 1] + 1;
            else dp[i] = dp[i - 1];
        }

        int min = dp[N];
        int max = (N / 3) * 2 + (N % 3 == 2 ? 1 : 0);
        System.out.println(min + " " + max);
    }
}
