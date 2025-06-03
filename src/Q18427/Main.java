package Q18427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 함께 블록 쌓기
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        List<Integer>[] arr = new List[N];
        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split(" ");
            List<Integer> blocks = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                blocks.add(Integer.parseInt(nums[j]));
            }
            arr[i] = blocks;
        }
        int[][] dp = new int[N + 1][H + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= N; i++) {
            List<Integer> blocks = arr[i - 1];
            for (int j = 0; j <= H; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            for (Integer block : blocks) {
                for (int j = block; j <= H; j++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - block]) % 10007;
                }
            }
        }
        System.out.println(dp[N][H]);
    }
}
