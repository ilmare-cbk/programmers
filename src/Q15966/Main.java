package Q15966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 군계일학
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[1_000_001];
        boolean[] exist = new boolean[1_000_001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[arr[i]] = 1;
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (exist[arr[i] - 1]) {
                dp[arr[i]] = dp[arr[i] - 1] + 1;
            }
            exist[arr[i]] = true;
            max = Math.max(max, dp[arr[i]]);
        }

        System.out.println(max);
    }
}
