package Q22115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 창영이와 커피
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
//        solution1(K, N, br);
        solution2(K, N, br);
    }

    private static void solution1(int K, int N, BufferedReader br) throws IOException {
        StringTokenizer st;
        int[][] dp = new int[K + 1][2];
        int[] caffeines = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            caffeines[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = K; j >= caffeines[i]; j--) {
                int caffeine = dp[j - caffeines[i]][0] + caffeines[i];
                if (caffeine == j) {
                    int count = dp[j - caffeines[i]][1] + 1;
                    dp[j][0] = caffeine;
                    dp[j][1] = dp[j][1] == 0 ? count : Math.min(dp[j][1], count);
                }
            }
        }
        System.out.println(dp[K][0] == K ? dp[K][1] : -1);
    }

    private static void solution2(int K, int N, BufferedReader br) throws IOException {
        StringTokenizer st;
        int[] caffeines = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            caffeines[i] = Integer.parseInt(st.nextToken());
        }

        int INF = 100001;
        int[] dp = new int[K + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = K; j >= caffeines[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j - caffeines[i]] + 1);
            }
        }
        System.out.println(dp[K] == INF ? -1 : dp[K]);
    }
}
