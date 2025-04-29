package Q28450;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 컨벤 데드가 하고싶어요
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int H = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = Long.MAX_VALUE;
        }

        for (int i = 0; i <= M; i++) {
            dp[0][i] = Long.MAX_VALUE;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = map[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
                }
            }
        }

        boolean answer = dp[N][M] <= H;
        if (answer) {
            System.out.println("YES");
            System.out.println(dp[N][M]);
        } else {
            System.out.println("NO");
        }
    }
}
