package Q2302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 극장 좌석
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = 1;

        if (N >= 1) dp[1] = 1;
        if (N >= 2) dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        List<Integer> vip = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            vip.add(Integer.parseInt(br.readLine()));
        }

        int answer = 1;
        int idx = 0;
        int sum = 1;
        for (int i = 1; i <= N; i++) {
            if (vip.contains(i)) {
                answer = answer * dp[i - idx - 1];
                idx = i;
            } else {
                sum = dp[i - idx];
            }
        }
        if (idx != N) {
            answer = answer * sum;
        }

        System.out.println(answer);
    }
}
