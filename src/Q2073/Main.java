package Q2073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수도배관공사
 */
public class Main {
    private static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] L = new int[P];
        int[] C = new int[P];
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[D + 1];
        dp[0] = INF;
        for (int i = 0; i < P; i++) {
            for (int j = D; j >= L[i]; j--) {
                dp[j] = Math.max(dp[j], Math.min(dp[j - L[i]], C[i]));
            }
        }
        System.out.println(dp[D]);
    }
}
