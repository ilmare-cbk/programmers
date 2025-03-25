package Q11444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 수 6
 */
public class Main {
    private static final int MOD = 1_000_000_007;
    private static long[][] base = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fibonacci(n));
    }

    private static long fibonacci(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return pow(n - 1)[0][0];
    }

    private static long[][] pow(long n) {
        if (n == 1) return base;

        long[][] temp = pow(n / 2);

        if (n % 2 != 0) {
            return matrixPow(matrixPow(temp, temp), base);
        }
        return matrixPow(temp, temp);
    }

    private static long[][] matrixPow(long[][] a, long[][] b) {
        long[][] r = new long[2][2];
        r[0][0] = cal(a[0][0], b[0][0], a[0][1], b[1][0]);
        r[0][1] = cal(a[0][0], b[0][1], a[0][1], b[1][1]);
        r[1][0] = cal(a[1][0], b[0][0], a[1][1], b[1][0]);
        r[1][1] = cal(a[1][0], b[0][1], a[1][1], b[1][1]);
        return r;
    }

    private static long cal(long a1, long b1, long a2, long b2) {
        return (((a1 % MOD) * (b1 % MOD)) % MOD + ((a2 % MOD) * (b2 % MOD)) % MOD) % MOD;
    }
}
