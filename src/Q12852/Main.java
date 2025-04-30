package Q12852;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 1로 만들기 2
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] idx = new int[N + 1];

        for (int i = N; i >= 1; i--) {
            if (i == N) dp[1] = 0;
            else {
                dp[N - i + 1] = dp[N - i] + 1;
                idx[N - i + 1] = N - i;
                if (i * 2 <= N) {
                    int n1 = dp[N - i + 1];
                    int n2 = dp[N - (i * 2) + 1] + 1;
                    dp[N - i + 1] = Math.min(n1, n2);
                    if (n2 < n1) {
                        idx[N - i + 1] = N - (i * 2) + 1;
                    }
                }
                if (i * 3 <= N) {
                    int n1 = dp[N - i + 1];
                    int n2 = dp[N - (i * 3) + 1] + 1;
                    dp[N - i + 1] = Math.min(n1, n2);
                    if (n2 < n1) {
                        idx[N - i + 1] = N - (i * 3) + 1;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int index = N;
        while (index != 0) {
            path.add(N - index + 1);
            index = idx[index];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[N]).append(System.lineSeparator());
        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
