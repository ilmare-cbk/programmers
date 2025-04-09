package Q7579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 앱
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] memory = new int[N];
        int[] cost = new int[N];
        int maxCost = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            maxCost += cost[i];
        }

        // dp[i] = 비용 i를 들였을 때 확보할 수 있는 최대 메모리
        int[] dp = new int[maxCost + 1];

        for (int i = 0; i < N; i++) {
            for (int j = maxCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        for (int i = 0; i <= maxCost; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}
