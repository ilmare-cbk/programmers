package Q10826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 피보나치 수 4
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n < 2) {
            System.out.println(n);
            return;
        }

        BigInteger f0 = BigInteger.ZERO;
        BigInteger f1 = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger tmp = f1;
            f1 = f0.add(f1);
            f0 = tmp;
        }
        System.out.println(f1);
    }
}
