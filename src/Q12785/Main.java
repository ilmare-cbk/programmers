package Q12785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 토쟁이의 등굣길
 */
public class Main {
    private static final int MOD = 1_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        long[][] dp = new long[h + 1][w + 1];
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (i == 1 || j == 1) dp[i][j] = 1;
                else dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        long answer = (dp[y][x] * dp[h - y + 1][w - x + 1]) % MOD;
        System.out.println(answer);
    }
}
