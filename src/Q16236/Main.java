package Q16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 아기 상어
 */
public class Main {
    private static int N, shark_r, shark_c;
    private static int[][] map;
    private static boolean[][] visited;
    private static int sharkSize = 2;
    private static int levelUpGage = 0;
    private static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int data = Integer.parseInt(st.nextToken());
                map[i][j] = data;
                if (data == 9) {
                    shark_r = i;
                    shark_c = j;
                    map[i][j] = 0; // 상어 위치를 0으로 설정
                }
            }
        }

        int cnt = 0;
        while (true) {
            int[] targetFish = bfs();
            if (targetFish == null) break;

            shark_r = targetFish[0];
            shark_c = targetFish[1];
            cnt += targetFish[2];
            map[shark_r][shark_c] = 0;

            levelUpGage++;
            if (levelUpGage == sharkSize) {
                sharkSize++;
                levelUpGage = 0;
            }
        }

        System.out.println(cnt);
    }

    private static int[] bfs() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        visited[shark_r][shark_c] = true;
        PriorityQueue<Position> queue = new PriorityQueue<>();
        queue.add(new Position(shark_r, shark_c, 0));

        Position targetFish = null;

        while (!queue.isEmpty()) {
            Position p = queue.poll();

            if (map[p.r][p.c] > 0 && map[p.r][p.c] < sharkSize) {
                if (targetFish == null ||
                        p.dist < targetFish.dist ||
                        (p.dist == targetFish.dist && (p.r < targetFish.r || (p.r == targetFish.r && p.c < targetFish.c)))) {
                    targetFish = p;
                }
                continue;
            }


            for (int[] m : move) {
                int dr = p.r + m[0];
                int dc = p.c + m[1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= N || visited[dr][dc] || map[dr][dc] > sharkSize) {
                    continue;
                }

                visited[dr][dc] = true;
                queue.add(new Position(dr, dc, p.dist + 1));
            }
        }

        return targetFish == null ? null : new int[]{targetFish.r, targetFish.c, targetFish.dist};
    }

    private static class Position implements Comparable<Position> {
        int r;
        int c;
        int dist;

        public Position(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Position o) {
            if (this.dist != o.dist) return this.dist - o.dist;
            else if (this.r != o.r) return this.r - o.r;
            else return this.c - o.c;
        }
    }
}
