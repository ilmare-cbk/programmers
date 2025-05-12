package Q1914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 하노이 탑
 */
public class Main {
    private static int cnt = 0;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[N + 1];
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.valueOf(3L);
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1].multiply(BigInteger.valueOf(2L)).add(BigInteger.ONE);
        }

        if (N <= 20) {
            hanoi(N, 1, 2, 3);
            System.out.println(cnt);
            System.out.println(sb);
        } else {
            System.out.println(dp[N]);
        }
    }

    private static void hanoi(int n, int c, int m, int t) {
        cnt++;
        if (n == 1) {
            sb.append(c).append(" ").append(t).append(System.lineSeparator());
        } else {
            hanoi(n - 1, c, t, m);
            sb.append(c).append(" ").append(t).append(System.lineSeparator());
            hanoi(n - 1, m, c, t);
        }
    }
}
