package Q1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분합
 */
public class Main {
    private static int N, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] seq = new int[N];
        String[] data = br.readLine().split(" ");
        for (int i = 0; i < data.length; i++) {
            seq[i] = Integer.parseInt(data[i]);
        }
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (true) {
            if (sum < S) {
                if (p2 == N) {
                    break;
                }
                sum += seq[p2];
                p2++;
            } else {
                if (p1 == N) {
                    break;
                }
                minLength = Math.min(minLength, p2 - p1);
                sum -= seq[p1];
                p1++;
            }
        }
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}
/*
6 12
1 6 6 1 1 10
2

10 10
1 2 3 4 5 6 7 8 9 10
1

10 21
20 1 2 3 4 5 6 7 8 9
2

10 10
1 1 1 1 1 1 1 1 1 10
1

10 8
4 1 1 1 1 1 2 2 2 2
4

10 11
1 1 1 1 1 1 1 1 1 1
0

10 13
1 1 1 1 1 1 1 1 1 13
1
 */