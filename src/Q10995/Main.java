package Q10995;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 별 찍기 - 20
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i % 2 == 0) {
                    sb.append(" ").append("*");
                } else {
                    sb.append("*");
                    if (j != N) {
                        sb.append(" ");
                    }
                }
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
