package 소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int M = Integer.parseInt(nums[0]);
        int N = Integer.parseInt(nums[1]);
        boolean[] nonPrime = new boolean[N + 1];
        nonPrime[0] = nonPrime[1] = true; // true = 소수 아님
        for (int i = 2; i <= N; i++) {
            if (nonPrime[i]) {
                continue;
            }
            for (int j = 2; j * i < nonPrime.length; j++) {
                nonPrime[j * i] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!nonPrime[i]) {
                sb.append(i).append(System.lineSeparator());
            }
        }
        System.out.println(sb);
    }
}
