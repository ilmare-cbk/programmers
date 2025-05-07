package Q12026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * BOJ 거리
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> B = new ArrayList<>();
        List<Integer> O = new ArrayList<>();
        List<Integer> J = new ArrayList<>();
        int[] dp = new int[N];
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'B') {
                if (B.isEmpty()) {
                    B.add(i);
                    continue;
                }
                if (!J.isEmpty()) {
                    B.add(i);
                    int min = Integer.MAX_VALUE;
                    for (Integer jIdx : J) {
                        int k = i - jIdx;
                        min = Math.min(min, k * k + dp[jIdx]);
                    }
                    dp[i] = min;
                } else {
                    dp[i] = -1;
                }
            } else if (c == 'O') {
                O.add(i);
                int min = Integer.MAX_VALUE;
                for (Integer bIdx : B) {
                    int k = i - bIdx;
                    min = Math.min(min, k * k + dp[bIdx]);
                }
                dp[i] = min;
            } else {
                if (!O.isEmpty()) {
                    J.add(i);
                    int min = Integer.MAX_VALUE;
                    for (Integer oIdx : O) {
                        int k = i - oIdx;
                        min = Math.min(min, k * k + dp[oIdx]);
                    }
                    dp[i] = min;
                } else {
                    dp[i] = -1;
                }
            }
        }
        System.out.println(dp[N - 1]);
    }
}
