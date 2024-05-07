package 이항계수1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int K = Integer.parseInt(nums[1]);
        System.out.println(factorial(N) / (factorial(N - K) * factorial(K)));
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return n;
        }
        return n * factorial(n - 1);
    }
}
