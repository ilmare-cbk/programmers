package Q27446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 랩실에서 잘 자요
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            dp[n] = n;
        }

        int sequenceIdx = 1;
        for (int i = 1; i <= N; i++) {
            if (dp[i] == 0 && i == 1) {
                dp[i] = 7;
            } else if (dp[i] != 0) {
                dp[i] = dp[i - 1];
            } else {
                int n1 = dp[i - 1] + 7;
                int n2 = dp[sequenceIdx - 1] + 5 + 2 * (i - sequenceIdx + 1);
                if (n1 < n2) {
                    dp[i] = n1;
                    sequenceIdx = i;
                } else {
                    dp[i] = n2;
                }
            }
        }

        System.out.println(dp[N]);
    }
}
