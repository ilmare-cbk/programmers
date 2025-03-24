package Q2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기
 */
public class Main {
    private static int N;
    private static int M;
    private static char[][] map;
    private static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int[][][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dist = new int[2][N][M];
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = data[j].charAt(0);
            }
        }
        bfs();
        int answer = Math.min(dist[0][N - 1][M - 1], dist[1][N - 1][M - 1]);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void bfs() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[0][i], Integer.MAX_VALUE);
            Arrays.fill(dist[1][i], Integer.MAX_VALUE);
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, false));
        dist[0][0][0] = 1;
        dist[1][0][0] = 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int r = node.r;
            int c = node.c;
            boolean broken = node.broken;
            for (int[] ints : move) {
                int dr = ints[0] + r;
                int dc = ints[1] + c;
                boolean movable = dr >= 0 && dr < N && dc >= 0 && dc < M;
                if (movable && map[dr][dc] == '0') {
                    if (broken) {
                        if (dist[1][dr][dc] > dist[1][r][c] + 1) {
                            dist[1][dr][dc] = dist[1][r][c] + 1;
                            queue.add(new Node(dr, dc, true));
                        }
                    } else {
                        if (dist[0][dr][dc] > dist[0][r][c] + 1) {
                            dist[0][dr][dc] = dist[0][r][c] + 1;
                            queue.add(new Node(dr, dc, false));
                        }
                    }
                } else if (movable && map[dr][dc] == '1') {
                    if (!broken) {
                        if (dist[1][dr][dc] > dist[0][r][c] + 1) {
                            dist[1][dr][dc] = dist[0][r][c] + 1;
                            queue.add(new Node(dr, dc, true));
                        }
                    }
                }
            }
        }
    }

    private static class Node {
        int r;
        int c;
        boolean broken;

        public Node(int r, int c, boolean broken) {
            this.r = r;
            this.c = c;
            this.broken = broken;
        }
    }
}
