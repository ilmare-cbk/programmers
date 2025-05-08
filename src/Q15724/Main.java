package Q15724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주지수
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (i == 1) map[i][j] = map[i][j - 1] + num;
                else if (j == 1) map[i][j] = map[i - 1][j] + num;
                else map[i][j] = map[i - 1][j] + map[i][j - 1] + num - map[i - 1][j - 1];
            }
        }
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            sb.append(map[x2][y2] - map[x2][y1 - 1] - map[x1 - 1][y2] + map[x1 - 1][y1 - 1]).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
/*
4 4
9 14 29 7
1 31 6 13
21 26 40 16
8 38 11 23
2
1 1 1 1
4 4 4 4

4 4
9 14 29 7
1 31 6 13
21 26 40 16
8 38 11 23
3
1 1 3 2
1 1 1 4
4 4 4 4
 */