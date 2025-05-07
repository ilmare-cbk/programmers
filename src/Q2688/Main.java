package Q2688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 줄어들지 않아
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[65][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= 64; i++) {
            long sum = 0;
            for (int j = 9; j >= 0; j--) {
                sum += dp[i - 1][j];
                dp[i][j] = sum;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += dp[n][i];
            }
            sb.append(sum).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
