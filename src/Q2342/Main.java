package Q2342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Dance Dance Revolution
 */
public class Main {
    private static int[][][] dp;
    private static final int MAX = 400_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> move = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d;
        while ((d = Integer.parseInt(st.nextToken())) != 0) {
            move.add(d);
        }
        int N = move.size();
        dp = new int[5][5][N + 1];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], MAX);
            }
        }

        dp[0][0][0] = 0;
        for (int i = 0; i < N; i++) {
            int next = move.get(i);
            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    // 왼발 이동
                    dp[next][r][i + 1] = Math.min(dp[next][r][i + 1], dp[l][r][i] + power(l, next));

                    // 오른발 이동
                    dp[l][next][i + 1] = Math.min(dp[l][next][i + 1], dp[l][r][i] + power(r, next));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                answer = Math.min(answer, dp[i][j][N]);
            };
        }

        System.out.println(answer);
    }

    private static int power(int current, int target) {
        if (current == 0) return 2;
        else if (current == target) return 1;
        else if (Math.abs(current - target) == 2) return 4;
        else return 3;
    }
}
