package Q6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 카잉 달력
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);
            sb.append(year(M, N, x - 1, y - 1)).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static int year(int M, int N, int x, int y) {
        int lcm = (M / gcd(M, N)) * N;
        for (int i = 0; i * M <= lcm; i++) {
            int year = M * i + x;
            if (year % N == y) {
                return year + 1;
            }
        }
        return -1;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
