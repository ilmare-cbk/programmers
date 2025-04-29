package Q1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 제곱 ㄴㄴ 수
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] nonSquared = new boolean[(int) (max - min + 1)];
        Arrays.fill(nonSquared, true);

        int cnt = nonSquared.length;
        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            long start = min % square == 0 ? min : (min / square) * square + square;

            for (long j = start; j <= max; j += square) {
                if (nonSquared[(int) (j - min)]) {
                    nonSquared[(int) (j - min)] = false;
                    cnt--;
                }
            }
        }

        System.out.println(cnt);
    }
}
