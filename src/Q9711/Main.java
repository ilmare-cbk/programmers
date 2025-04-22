package Q9711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 피보나치
 */
public class Main {
    private static final String MSG = "Case #%d: ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            long f1 = 1, f0 = 0;
            for (int j = 2; j <= P; j++) {
                long tmp = f1;
                f1 = (tmp + f0) % Q;
                f0 = tmp;
            }

            sb.append(String.format(MSG, i)).append(f1 % Q).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
