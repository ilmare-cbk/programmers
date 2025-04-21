package Q2670;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 연속부분최대곱
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N + 1];
        double[] dp = new double[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        double max = 0;
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[i] = arr[i];
            } else {
                dp[i] = Math.max(arr[i] * dp[i - 1], arr[i]);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.printf("%.3f", max);
    }
}
