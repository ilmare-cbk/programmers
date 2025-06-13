package Q1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수열의 합
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = N / L;
            for (int i = num; i > Math.max(num - L, -1); i--) {
                long sum = 0;
                for (int j = i; j < i + L; j++) {
                    sum += j;
                    sb.append(j).append(" ");
                }
                if (sum == N) {
                    System.out.println(sb);
                    return;
                }
                sb.setLength(0);
            }
            if (L == 100) {
                System.out.println(-1);
                return;
            }
            L++;
        }
    }
}
