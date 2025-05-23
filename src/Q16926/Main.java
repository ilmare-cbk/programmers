package Q16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 돌리기 1
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r = 0;
        int n = N;
        int m = M;
        while (n != 0 && m != 0) {
            int repeat = R % (2 * (n + m) - 4);
            while (repeat-- > 0) {
                int i = 1 + r;
                int j = 1 + r;
                int cur = arr[i][j];
                int cnt = 2 * (n + m) - 4;
                while (cnt-- > 0) {
                    if (i == 1 + r && j > 1 + r && j <= M - r) {
                        int next = arr[i][j - 1];
                        arr[i][j - 1] = cur;
                        j = j - 1;
                        cur = next;
                    } else if (j == 1 + r && i >= 1 + r && i < N - r) {
                        int next = arr[i + 1][j];
                        arr[i + 1][j] = cur;
                        i = i + 1;
                        cur = next;
                    } else if (i == N - r && j >= 1 + r && j < M - r) {
                        int next = arr[i][j + 1];
                        arr[i][j + 1] = cur;
                        j = j + 1;
                        cur = next;
                    } else if (j == M - r && i > 1 + r && i <= N - r) {
                        int next = arr[i - 1][j];
                        arr[i - 1][j] = cur;
                        i = i - 1;
                        cur = next;
                    }
                }
            }
            r++;
            n = n - 2;
            m = m - 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
