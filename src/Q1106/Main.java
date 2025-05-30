package Q1106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 호텔
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] price = new int[N];
        int[] customer = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            price[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[C + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= C; j++) {
                if (j <= customer[i]) {
                    dp[j] = Math.min(dp[j], dp[0] + price[i]);
                } else {
                    dp[j] = Math.min(dp[j], dp[j - customer[i]] + price[i]);
                }
            }
        }
        System.out.println(dp[C]);
    }
}
