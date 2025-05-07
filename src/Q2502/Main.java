package Q2502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 떡 먹는 호랑이
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] C = new int[D - 2];
        int A = 1, B = 1;

        for (int i = 0; i <= D - 3; i++) {
            if (i == 0 || i == 1) C[i] = 1;
            else C[i] = C[i - 1] + C[i - 2];
        }

        if (D >= 3) A = C[D - 3];
        if (D >= 4) B = C[D - 4] + C[D - 3];

        for (int a = 1; a * A <= K; a++) {
            if ((K - a * A) % B == 0) {
                int b = (K - a * A) / B;
                if (a <= b) {
                    System.out.println(a);
                    System.out.println(b);
                    break;
                }
            }
        }
    }
}
