package Q16194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 카드 구매하기 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 10_000_001);

        for (int i = 1; i <= N; i++) {
            int p = P[i];
            for (int j = 1; j <= N; j++) {
                if (j == i) dp[j] = Math.min(dp[j], p);
                else if (j > i) dp[j] = Math.min(dp[j], dp[j - i] + p);
            }
        }

        System.out.println(dp[N]);
    }
}
