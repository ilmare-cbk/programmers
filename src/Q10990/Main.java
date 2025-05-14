package Q10990;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 15
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N + i; j++) {
                if (j == 2 * N) continue;
                if (j == N - i + 1 || j == 2 * N - (N - i + 1)) sb.append("*");
                else sb.append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
