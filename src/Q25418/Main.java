package Q25418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수 a를 k로 만들기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K - A + 1];
        for (int i = A + 1; i <= K; i++) {
            dp[i - A] = dp[i - A - 1] + 1;
            if (i >= 2 * A && i % 2 == 0) {
                dp[i - A] = Math.min(dp[i - A], dp[i / 2 - A] + 1);
            }
        }
        System.out.println(dp[K - A]);
    }
}
