package Q1788;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 수의 확장
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sign, value;

        if (n == 0) {
            sign = 0;
            value = 0;
        } else {
            int absN = Math.abs(n);
            int[] dp = new int[absN + 1];
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i <= absN; i++) {
                dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000_000;
            }

            value = dp[absN];
            if (n < 0 && absN % 2 == 0) {
                sign = -1;
            } else {
                sign = 1;
            }
        }

        System.out.println(sign);
        System.out.println(value);
    }
}
