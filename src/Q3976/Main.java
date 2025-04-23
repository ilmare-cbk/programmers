package Q3976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 역습
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (c-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l1 = Integer.parseInt(st.nextToken());
            int l2 = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            int[] p1 = new int[n];
            int[] d1 = new int[n];
            int[] p2 = new int[n];
            int[] d2 = new int[n];
            int[] dp1 = new int[n + 1];
            int[] dp2 = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n; i++) {
                p1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n; i++) {
                d1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n; i++) {
                p2[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n; i++) {
                d2[i] = Integer.parseInt(st.nextToken());
            }

            dp1[1] = l1;
            dp2[1] = l2;

            for (int i = 2; i <= n; i++) {
                dp1[i] = Math.min(dp2[i - 1] + p2[i - 1], dp1[i - 1] + d1[i - 1]);
                dp2[i] = Math.min(dp1[i - 1] + p1[i - 1], dp2[i - 1] + d2[i - 1]);
            }

            sb.append(Math.min(dp1[n] + s1, dp2[n] + s2)).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
