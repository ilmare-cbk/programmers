package Q1793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 타일링
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int n = Integer.parseInt(line);
            BigInteger[] dp = new BigInteger[n + 1];
            if (n >= 0) dp[0] = BigInteger.ZERO;
            if (n >= 1) dp[1] = BigInteger.ONE;
            if (n >= 2) dp[2] = BigInteger.valueOf(3);

            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 2].multiply(BigInteger.valueOf(2)).add(dp[i - 1]);
            }

            sb.append(dp[n]).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
