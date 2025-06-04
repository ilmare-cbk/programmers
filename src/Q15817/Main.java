package Q15817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배수 공사
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] L = new int[N];
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            L[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = x; j >= 0; j--) {
                for (int k = 1; k <= C[i] && j >= k * L[i]; k++) {
                    dp[j] += dp[j - k * L[i]];
                }
            }
        }
        System.out.println(dp[x]);
    }
}
