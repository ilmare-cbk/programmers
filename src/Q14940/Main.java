package Q14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 쉬운 최단거리
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] answer = new int[n][m];

        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < data.length; j++) {
                int num = Integer.parseInt(data[j]);
                if (num == 2) {
                    d1 = i;
                    d2 = j;
                }
                if (num == 0) {
                    // 원래 갈 수 없는 땅은 0으로 초기화
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = -1;
                }
                map[i][j] = num;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        answer[d1][d2] = 0;
        visited[d1][d2] = true;
        queue.offer(new Node(d1, d2));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int n1 = node.getN();
            int m1 = node.getM();

            // 상
            if (n1 - 1 >= 0 && map[n1 - 1][m1] == 1 && !visited[n1 - 1][m1]) {
                queue.offer(new Node(n1 - 1, m1));
                answer[n1 - 1][m1] = answer[n1][m1] + 1;
                visited[n1 - 1][m1] = true;
            }
            // 하
            if (n1 + 1 < n && map[n1 + 1][m1] == 1 && !visited[n1 + 1][m1]) {
                queue.offer(new Node(n1 + 1, m1));
                answer[n1 + 1][m1] = answer[n1][m1] + 1;
                visited[n1 + 1][m1] = true;
            }
            // 좌
            if (m1 - 1 >= 0 && map[n1][m1 - 1] == 1 && !visited[n1][m1 - 1]) {
                queue.offer(new Node(n1, m1 - 1));
                answer[n1][m1 - 1] = answer[n1][m1] + 1;
                visited[n1][m1 - 1] = true;
            }
            // 우
            if (m1 + 1 < m && map[n1][m1 + 1] == 1 && !visited[n1][m1 + 1]) {
                queue.offer(new Node(n1, m1 + 1));
                answer[n1][m1 + 1] = answer[n1][m1] + 1;
                visited[n1][m1 + 1] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private static class Node {
        private final int n;
        private final int m;

        public Node(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }
    }
}
