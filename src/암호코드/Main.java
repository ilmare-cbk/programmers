package 암호코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        long[] dp = new long[5000];
        long answer = 0;
        for (int i = 0; i < code.length(); i++) {
            if (i == 0) {
                dp[i] = inRange(code.charAt(i) - '0') ? 1 : 0;
            } else if (i == 1) {
                dp[i] = (inRange(code.charAt(i) - '0') ? dp[i - 1] : 0) +
                        (inRange(code.substring(0, i + 1)) ? 1 : 0);
            } else {
                dp[i] = ((inRange(code.charAt(i) - '0') ? dp[i - 1] : 0) % MOD +
                        (inRange(code.substring(i - 1, i + 1)) ? dp[i - 2] : 0) % MOD) % MOD;
            }
            answer = dp[i];
            if (answer == 0) {
                break;
            }
        }
        System.out.println(answer);
    }

    private static boolean inRange(String subCode) {
        int n = Integer.parseInt(subCode);
        if (subCode.length() < 2) {
            return 1 <= n && n <= 9;
        }
        return 10 <= n && n <= 26;
    }

    private static boolean inRange(int n) {
        return 1 <= n && n <= 26;
    }
}
