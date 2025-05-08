package Q2780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 비밀번호
 */
public class Main {

    private static final int MOD = 1_234_567;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[1001][10];
        List<Integer>[] graph = new List[10];
        for (int i = 0; i < 10; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(7);
        graph[1].add(2);
        graph[1].add(4);
        graph[2].add(1);
        graph[2].add(3);
        graph[2].add(5);
        graph[3].add(2);
        graph[3].add(6);
        graph[4].add(1);
        graph[4].add(5);
        graph[4].add(7);
        graph[5].add(2);
        graph[5].add(4);
        graph[5].add(6);
        graph[5].add(8);
        graph[6].add(3);
        graph[6].add(5);
        graph[6].add(9);
        graph[7].add(4);
        graph[7].add(8);
        graph[7].add(0);
        graph[8].add(5);
        graph[8].add(7);
        graph[8].add(9);
        graph[9].add(6);
        graph[9].add(8);

        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 1) dp[i][j] = 1;
                else if (i == 2) dp[i][j] = graph[j].size();
                else {
                    int sum = 0;
                    for (Integer num : graph[j]) {
                        sum = (sum + dp[i - 1][num]) % MOD;
                    }
                    dp[i][j] = sum;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum = (sum + dp[n][i]) % MOD;
            }
            sb.append(sum).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
