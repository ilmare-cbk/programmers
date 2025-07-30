package P258705;

/**
 * 산 모양 타일링
 */
public class Solution {
    private static final int MOD = 10007;

    public static void main(String[] args) {
//        System.out.println(solution(4, new int[]{1, 1, 0, 1}));
//        System.out.println(solution(2, new int[]{0, 1}));
        System.out.println(solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    public static int solution(int n, int[] tops) {
        int[] dp = new int[2 * (n + 1)];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 2 * n + 1; i++) {
            if (i % 2 == 0 && tops[(i / 2) - 1] == 1) {
                dp[i] = (2 * dp[i - 1] + dp[i - 2]) % MOD;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }
        }
        return dp[2 * n + 1];
    }
}
