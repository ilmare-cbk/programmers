package Q1509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬 분할
 */
public class Main {
    private static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        int N = s.length();

        boolean[][] isPalindrome = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            isPalindrome[i][i] = true; // 기본적으로 원소 자기 자신은 팰린드롬
        }
        for (int len = 2; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || isPalindrome[i + 1][j - 1]) {
                        isPalindrome[i][j] = true;
                    }
                }
            }
        }

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[j - 1][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        System.out.println(dp[N]);
    }
}
