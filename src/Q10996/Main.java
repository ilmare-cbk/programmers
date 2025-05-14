package Q10996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 21
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println("*");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 2 * N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 1) {
                        sb.append(" ");
                    } else {
                        sb.append("*");
                        if (j == N) sb.append(" ");
                    }
                } else {
                    if (j % 2 == 1) {
                        sb.append("*").append(" ");
                    }
                }
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
