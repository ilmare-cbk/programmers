package Q1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Fly me to the Alpha Centauri
 */
public class Main {
    private static long[] dp = new long[65535 * 2 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        dp[1] = 1;
        for (int i = 2; i <= 65535 * 2; i = i + 2) {
            dp[i] = (long) (i / 2) * (i / 2 + 1);
            dp[i - 1] = dp[i] - i / 2;
        }

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int answer = findIdx(y - x);
            sb.append(answer).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static int findIdx(int num) {
        int l = 0, r = dp.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (dp[mid] == num) return mid;
            else if (dp[mid] < num) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
/*
30
0 1
0 2
0 3
0 4
0 5
0 6
0 7
0 8
0 9
0 10
0 11
0 12
0 13
0 14
0 15
0 16
0 17
0 18
0 19
0 20
0 21
0 22
0 23
0 24
0 25
0 26
0 27
0 28
0 29
0 30
 */
