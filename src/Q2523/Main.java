package Q2523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 13
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 2 * N - 1; i++) {
            for (int j = 1; j <= Math.min(i, 2 * N - i); j++) {
                sb.append("*");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}