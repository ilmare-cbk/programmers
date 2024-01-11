package 별찍기17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (i == N) {
                for (int j = 1; j <= 2 * N - 1; j++) {
                    sb.append("*");
                }
                break;
            }
            for (int j = 1; j < N - i + 1; j++) {
                sb.append(" ");
            }
            for (int j = N - (i - 1); j <= N + i - 1; j++) {
                if (j == N - i + 1 || j == (N - i + 1) + (2 * (i - 1))) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
