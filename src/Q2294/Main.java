package Q2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 동전 2
 */
public class Main {
    private static final int MAX = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] v = new boolean[100001];
        for (int i = 0; i < n; i++) {
            v[Integer.parseInt(br.readLine())] = true;
        }
        List<Integer> coin = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            if (v[i]) coin.add(i);
        }
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 10001);

        for (Integer c : coin) {
            for (int i = c; i <= k; i++) {
                if (i == c) dp[i] = 1;
                else dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }

        System.out.println(dp[k] == MAX ? -1 : dp[k]);
    }
}
