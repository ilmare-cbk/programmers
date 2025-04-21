package Q25214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 크림 파스타
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = 1_000_000_001;
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (i == 1) {
                min = tmp;
            }
            dp[i] = Math.max(dp[i - 1], tmp - min);
            if (tmp < min) {
                min = tmp;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }
}
