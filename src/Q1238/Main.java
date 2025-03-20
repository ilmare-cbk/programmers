package Q1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 파티
 */
public class Main {
    private static int N;
    private static int M;
    private static int X;
    private static int[][] map;
    private static int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i != j) {
                    map[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer data = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(data.nextToken());
            int b = Integer.parseInt(data.nextToken());
            int t = Integer.parseInt(data.nextToken());
            map[a][b] = t;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(map[i][X] + map[X][i], answer);
        }

        System.out.println(answer);
    }
}
