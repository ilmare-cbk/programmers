package Q14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 연구소
 */
public class Main {
    private static int N;
    private static int M;
    private static int[][] map;
    private static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int empty = 0;
    private static boolean[][] visited;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer data = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(data.nextToken());
                if (map[i][j] == 0) {
                    empty++;
                }
            }
        }
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int cnt) {
        if (cnt == 3) {
            answer = Math.max(bfs(empty - 3), answer);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int bfs(int empty) {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        Queue<Virus> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.add(new Virus(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Virus virus = queue.poll();
            int i = virus.i;
            int j = virus.j;
            for (int[] ints : move) {
                int next_i = i + ints[0];
                int next_j = j + ints[1];
                if (next_i >= 0 && next_i < N && next_j >= 0 && next_j < M && map[next_i][next_j] == 0) {
                    if (!visited[next_i][next_j]) {
                        visited[next_i][next_j] = true;
                        queue.add(new Virus(next_i, next_j));
                        empty--;
                    }
                }
            }
        }
        return empty;
    }

    private static class Virus {
        int i;
        int j;

        public Virus(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
