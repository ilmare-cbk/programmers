package P1844;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 게임 맵 최단거리
 */
public class Solution {
    private static final int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }

    public static int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        maps[N - 1][M - 1] = -1;


        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int r = node.r + move[i][0];
                int c = node.c + move[i][1];
                if (isMovable(N, M, r, c) && maps[r][c] != 0) {
                    if (!visited[r][c]) {
                        visited[r][c] = true;
                        maps[r][c] = maps[node.r][node.c] + 1;
                        queue.add(new Node(r, c));
                        continue;
                    }

                    if (maps[r][c] > maps[node.r][node.c] + 1) {
                        maps[r][c] = maps[node.r][node.c] + 1;
                        queue.add(new Node(r, c));
                    }
                }
            }

        }

        return maps[N - 1][M - 1];
    }

    private static boolean isMovable(int N, int M, int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
