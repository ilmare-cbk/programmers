package Q4097;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수익
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            long[] dp = new long[N];
            for (int i = 0; i < N; i++) {
                dp[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 1; i < N; i++) {
                dp[i] = Math.max(dp[i], dp[i - 1] + dp[i]);
            }

            long max = Long.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                max = Math.max(max, dp[i]);
            }

            sb.append(max).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
/*
6
-100
-111
-222
1
2
-1000
0
 */