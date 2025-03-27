package Q2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 치즈
 */
public class Main {
    private static int N, M;
    private static int[][] map;
    private static int[][] contact;
    private static boolean[][] visited;
    private static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static boolean update = true;
    // 치즈 : 1
    // 공기 : 0

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        contact = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(row.nextToken());
            }
        }

        int cnt = 0;
        while (update) {
            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], false);
                Arrays.fill(contact[i], 0);
            }
            update = false;
            dfs(0, 0);
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 1 && contact[r][c] >= 2) {
                        map[r][c] = 0;
                        update = true;
                    }
                }
            }
            if (update) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    /**
     * 공기일 때만 dfs 수행
     *
     * @param r
     * @param c
     */
    private static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int[] m : move) {
            int dr = r + m[0];
            int dc = c + m[1];
            if (dr < 0 || dr >= N || dc < 0 || dc >= M || visited[dr][dc]) {
                continue;
            }
            if (map[dr][dc] == 0) {
                dfs(dr, dc);
            } else if (map[dr][dc] == 1) {
                contact[dr][dc]++;
            }
        }
    }
}
/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 1 1 0 0 0 0
0 0 0 1 1 0 1 1 0
0 0 1 1 1 1 1 1 0
0 0 1 1 1 1 1 0 0
0 0 1 1 0 1 1 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0

9 9
0 0 0 0 0 0 0 0 0
0 0 0 0 1 0 0 0 0
0 1 1 0 1 0 1 0 0
0 1 1 1 1 1 1 0 0
0 0 1 0 1 1 0 1 0
0 1 0 1 1 0 1 0 0
0 0 1 0 1 0 1 1 0
0 1 1 1 0 0 1 0 0
0 0 0 0 0 0 0 0 0

7 7
0 0 0 0 0 0 0
0 0 0 1 0 0 0
0 0 1 0 1 0 0
0 1 0 1 0 1 0
0 0 1 0 1 0 0
0 0 0 1 0 0 0
0 0 0 0 0 0 0

5 5
0 0 0 0 0
0 1 1 1 0
0 1 0 1 0
0 1 1 1 0
0 0 0 0 0
 */
