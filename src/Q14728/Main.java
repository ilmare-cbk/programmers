package Q14728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int[] dp = new int[T + 1];
        int[][] chapters = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            chapters[i][0] = Integer.parseInt(st.nextToken());
            chapters[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = T; j >= chapters[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - chapters[i][0]] + chapters[i][1]);
            }
        }
        System.out.println(dp[T]);
    }
}
