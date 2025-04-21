package Q24417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 알고리즘 수업 - 피보나치 수 2
 */
public class Main {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] base = {{1, 1}, {1, 0}};
        long result = power(base, n - 1)[0][0];
        System.out.println(result + " " + (n - 2));
    }

    private static long[][] power(long[][] base, int exp) {
        if (exp == 1) return base;

        long[][] tmp = power(base, exp / 2);
        long[][] result = multiply(tmp, tmp);
        if (exp % 2 == 0) {
            return result;
        }
        return multiply(base, result);
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
        return result;
    }
}
