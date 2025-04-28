package Q27914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 인터뷰
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];
        int[] X = new int[Q + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 1; i <= Q; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, X[i]);
        }

        long[][] dp = new long[N + 1][2];

        for (int i = 1; i <= max; i++) {
            if (i == 1) {
                if (A[i] != K) {
                    dp[i][0] = 1;
                    dp[i][1] = 1;
                }
            } else {
                if (A[i] == K) dp[i][0] = dp[i - 1][0];
                else {
                    dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + 1;
                    dp[i][1] = dp[i - 1][1] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Q; i++) {
            sb.append(dp[X[i]][0]).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
/*
10 1 1
1 2 3 1 3 1 3 3 3 3
10
 */