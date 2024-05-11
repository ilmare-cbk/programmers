package Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int r = 31;
    private static int mod = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer = 0;
        long R = 1;
        for (int i = 0; i < L; i++) {
            if (i != 0) {
                R = (R * r) % mod;
            }
            answer += ((str.charAt(i) - 96) * R) % mod;
        }
        System.out.println(answer % mod);
    }
}
