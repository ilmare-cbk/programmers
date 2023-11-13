package 일로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 * 3. 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력
 * <p>
 * 입력 : 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.
 */
public class Main {
    private static int dp[] = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        calculate(n);
        System.out.println(dp[n]);
    }

    private static void calculate(int n) {
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
    }
}
