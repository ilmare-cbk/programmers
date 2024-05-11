package 부녀회장이퇼테야;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp(k, n));
            T--;
        }
    }

    private static int dp(int k, int n) {
        if (n == 1 || k == 0) {
            return n;
        }
        return dp(k, n - 1) + dp(k - 1, n);
    }
}
