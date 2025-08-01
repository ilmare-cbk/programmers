package P43105;

/**
 * 정수 삼각형
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public static int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            int[] numbers = triangle[i];
            for (int j = 0; j < numbers.length; j++) {
                if (j == 0) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + numbers[j]);
                else if (j == numbers.length - 1) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + numbers[j]);
                else
                    dp[i][j] = Math.max(Math.max(dp[i][j], dp[i - 1][j - 1] + numbers[j]), dp[i - 1][j] + numbers[j]);
            }
        }
        for (int i = 0; i < triangle[n - 1].length; i++) {
            answer = Math.max(answer, dp[n - 1][i]);
        }
        return answer;
    }
}
