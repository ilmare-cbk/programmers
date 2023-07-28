package 피보나치수;

public class Solution {
    public int solution(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 100_000;
        Solution solution = new Solution();
        int answer = solution.solution(n);

        System.out.println(answer);
    }
}
