package Q10211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Maximum Subarray
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                if (i == 0) dp[i] = arr[i];
                else {
                    dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
                }
                max = Math.max(max, dp[i]);
            }
            sb.append(max).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
