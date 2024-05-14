package 구간합구하기4;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (i == 0) {
                dp[i] = number;
            } else {
                dp[i] = dp[i - 1] + number;
            }
        }
        while (M > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int sum = s == 1 ? dp[e - 1] : dp[e - 1] - dp[s - 2];
            bw.write(sum + System.lineSeparator());
            M--;
        }
        bw.flush();
        bw.close();
    }
}
