package Q9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 신나는 함수 실행
 */
public class Main {
    private static int[][][] dp;
    private static final String MSG = "w(%d, %d, %d) = %d";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp = new int[21][21][21];

        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    if (i == 0 || j == 0 || k == 0) dp[i][j][k] = 1;
                    else if (i < j && j < k) dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                    else
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            if (a <= 0 || b <= 0 || c <= 0) sb.append(String.format(MSG, a, b, c, 1)).append(System.lineSeparator());
            else if (a > 20 || b > 20 || c > 20)
                sb.append(String.format(MSG, a, b, c, dp[20][20][20])).append(System.lineSeparator());
            else sb.append(String.format(MSG, a, b, c, dp[a][b][c])).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

}
