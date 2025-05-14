package Q13015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 23
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int c = 2 * N + 2 * N - 3;
        int r = 2 * N - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= r; i++) {
            int i1 = i;
            if (i > (r + 1) / 2) i1 = 2 * N - i;
            for (int j = 1; j <= c - i1 + 1; j++) {
                if (i1 == 1) {
                    if (j >= N + i1 && j <= c - N - i1 + 1) sb.append(" ");
                    else sb.append("*");
                } else {
                    if (j == i1 || j == i1 + N - 1 || j == c - i1 + 1 || j == c - i1 + 1 - N + 1) sb.append("*");
                    else sb.append(" ");
                }
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
