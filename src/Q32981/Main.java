package Q32981;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 찐 Even Number
 */
public class Main {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (Q-- > 0) {
            int N = Integer.parseInt(br.readLine());
            if (N == 1) sb.append(5).append(System.lineSeparator());
            else {
                long tmp = pow(N - 1);
                long answer = (4 * tmp) % MOD;
                sb.append(answer).append(System.lineSeparator());
            }
        }

        System.out.println(sb);
    }

    private static long pow(int exp) {
        if (exp == 1) return 5;

        long tmp = pow(exp / 2);
        long result = (tmp * tmp) % MOD;

        if (exp % 2 == 0) {
            return result;
        }

        return (5 * result) % MOD;
    }
}
