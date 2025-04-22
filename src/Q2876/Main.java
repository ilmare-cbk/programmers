package Q2876;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 그래픽스 퀴즈
 */
public class Main {
    private static int cnt = 0;
    private static int grade = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[][] dp = new int[N][6];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int s1 = arr[i][0];
            int s2 = arr[i][1];

            if (i == 0) {
                dp[i][s1] = 1;
                dp[i][s2] = 1;
            } else {
                dp[i][s1] = dp[i - 1][s1] + 1;
                dp[i][s2] = dp[i - 1][s2] + 1;
            }

            update(dp[i][s1], s1);
            update(dp[i][s2], s2);
        }

        System.out.println(cnt + " " + grade);
    }

    private static void update(int dp, int g) {
        if (dp > cnt) {
            cnt = dp;
            grade = g;
        } else if (dp == cnt) {
            if (g < grade) {
                grade = g;
            }
        }
    }
}
