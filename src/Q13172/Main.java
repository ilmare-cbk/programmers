package Q13172;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Σ
 */
public class Main {
    private static final int MOD = 1_000_000_007;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        long answer = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int gcd = gcd(n, s);
            n = n / gcd;
            s = s / gcd;
            answer = ((answer % MOD) + (((s % MOD) * reversed(n, MOD - 2) % MOD) % MOD) % MOD) % MOD;
        }
        System.out.println(answer);
    }

    private static long reversed(int n, int exponent) {
        if (exponent == 1) {
            return n;
        }

        long temp = reversed(n, exponent / 2);

        long i = ((temp % MOD) * (temp % MOD)) % MOD;
        if (exponent % 2 != 0) {
            return ((i % MOD) * (n % MOD)) % MOD;
        }

        return i;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
