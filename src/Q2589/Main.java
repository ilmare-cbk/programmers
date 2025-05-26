package Q2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 보물섬
 */
public class Main {
    private static int N, M;
    private static char[][] map;
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.println(max);
    }

    private static int bfs(int i, int j) {
        boolean[][] visited = new boolean[N][M];
        Queue<Land> q = new LinkedList<>();
        q.add(new Land(i, j, 0));
        visited[i][j] = true;
        int max = 0;

        while (!q.isEmpty()) {
            Land node = q.poll();
            max = node.hour;

            for (int[] d : directions) {
                int dr = node.r + d[0];
                int dc = node.c + d[1];
                if (isValid(dr, dc) && !visited[dr][dc]) {
                    visited[dr][dc] = true;
                    q.add(new Land(dr, dc, node.hour + 1));
                }
            }
        }

        return max;
    }

    private static boolean isValid(int dr, int dc) {
        return dr >= 0 && dr < N && dc >= 0 && dc < M && map[dr][dc] == 'L';
    }

    private static class Land {
        int r;
        int c;
        int hour;

        public Land(int r, int c, int hour) {
            this.r = r;
            this.c = c;
            this.hour = hour;
        }
    }
}
/*
5 5
LLLLL
LWWWL
LWWWL
LWWWL
LLLLL

3 3
LLW
WWW
WWW

1 2
LL

3 3
LLW
WWW
WWW

7 7
WLLLLLW
LWLWLWW
LLLWLWW
LWWWLWW
LLLLLWW
LWWWWWW
WWWWWWW

4 4
LLLL
LLLL
LLLL
LLLL

7 7
LLLWLLL
LLLWLLL
LLWWLLL
WWWWLLL
WWWWWWW
WWWWWWW
WWWWWWW
 */