package Q11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 구간 합 구하기 5
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] arr = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String[] nums = br.readLine().split(" ");
            for (int j = 1; j <= nums.length; j++) {
                int n = Integer.parseInt(nums[j - 1]);
                arr[i][j] = n;
                dp[i][j] = dp[i][j - 1] + n;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            String[] pos = br.readLine().split(" ");
            int x1 = Integer.parseInt(pos[0]);
            int y1 = Integer.parseInt(pos[1]);
            int x2 = Integer.parseInt(pos[2]);
            int y2 = Integer.parseInt(pos[3]);
            int answer = 0;
            for (int i = x1; i <= x2; i++) {
                answer += dp[i][y2] - dp[i][y1 - 1];
            }
            sb.append(answer).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
