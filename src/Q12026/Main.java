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
            if (i == 0) {
                B.add(i);
                continue;
            }

            char c = s.charAt(i);
            if (c == 'B') {
                jump(J, B, i, dp);
            } else if (c == 'O') {
                jump(B, O, i, dp);
            } else {
                jump(O, J, i, dp);
            }
        }
        System.out.println(dp[N - 1]);
    }

    private static void jump(List<Integer> prev, List<Integer> next, int i, int[] dp) {
        if (!prev.isEmpty()) {
            next.add(i);
            int min = Integer.MAX_VALUE;
            for (Integer idx : prev) {
                int k = i - idx;
                min = Math.min(min, k * k + dp[idx]);
            }
            dp[i] = min;
        } else {
            dp[i] = -1;
        }
    }
}
