package Q25706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 자전거 묘기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i + 1] = Integer.parseInt(st.nextToken());
        }

        dp[N] = 1;
        for (int n = N - 1; n > 0; n--) {
            if (arr[n] + n >= N) dp[n] = 1;
            else dp[n] = dp[arr[n] + n + 1] + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(dp[i + 1]).append(" ");
        }
        System.out.println(sb);
    }
}
