package P12902;

/**
 * 3 x n 타일링
 */
public class Solution {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static int solution(int n) {
        if (n % 2 != 0) return 0;

        long[] dp = new long[n + 1];
        dp[2] = 3;
        long sum = 1;
        for (int i = 4; i <= n; i += 2) {
            sum = (sum + dp[i - 4]) % MOD;
            dp[i] = (3 * dp[i - 2] + 2 * sum) % MOD;
        }
        return (int) (dp[n] % MOD);
    }
}
