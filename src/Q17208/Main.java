package Q17208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 카우버거 알바생
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] cheeseburger = new int[N];
        int[] potato = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cheeseburger[i] = Integer.parseInt(st.nextToken());
            potato[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[M + 1][K + 1];
        for (int i = 0; i < N; i++) {
            for (int m = M; m >= cheeseburger[i]; m--) {
                for (int k = K; k >= potato[i]; k--) {
                    dp[m][k] = Math.max(dp[m][k], dp[m - cheeseburger[i]][k - potato[i]] + 1);
                }
            }
        }
        System.out.println(dp[M][K]);
    }
}
