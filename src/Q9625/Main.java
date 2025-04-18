package Q9625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BABBA
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] B = new int[K + 1];

        if (K >= 1) {
            B[1] = 1;
        }
        if (K >= 2) {
            B[2] = 1;
        }

        for (int i = 3; i <= K; i++) {
            B[i] = B[i - 1] + B[i - 2];
        }

        System.out.println(B[K - 1] + " " + B[K]);
    }
}
