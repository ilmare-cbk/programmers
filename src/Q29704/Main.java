package Q29704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 벼락치기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] p = new int[N][2];
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
            max += p[i][1];
        }
        int[] dp = new int[T + 1];
        Arrays.fill(dp, max);
        for (int i = 0; i < N; i++) {
            for (int j = T; j >= p[i][0]; j--) {
                dp[j] = Math.min(dp[j], dp[j - p[i][0]] - p[i][1]);
            }
        }
        System.out.println(dp[T]);
    }
}
