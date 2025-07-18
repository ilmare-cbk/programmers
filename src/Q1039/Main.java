package Q1039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 교환
 */
public class Main {
    private static int N, K;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N < 10) {
            System.out.println(-1);
            return;
        }

        visited = new boolean[K + 1][1_000_001];
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        int max = -1;
        queue.add(new Node(String.valueOf(N), 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.depth == K) {
                max = Math.max(max, Integer.parseInt(cur.n));
                continue;
            }

            for (int i = 0; i < cur.n.length() - 1; i++) {
                for (int j = i + 1; j < cur.n.length(); j++) {
                    StringBuilder sb = new StringBuilder(cur.n);

                    if (i == 0 && sb.charAt(j) == '0') continue;

                    char temp = sb.charAt(i);
                    sb.setCharAt(i, sb.charAt(j));
                    sb.setCharAt(j, temp);

                    String num = sb.toString();
                    int n = Integer.parseInt(num);
                    if (!visited[cur.depth + 1][n]) {
                        visited[cur.depth + 1][n] = true;
                        queue.add(new Node(num, cur.depth + 1));
                    }
                }
            }
        }

        return max;
    }

    private static class Node {
        String n;
        int depth;

        public Node(String n, int depth) {
            this.n = n;
            this.depth = depth;
        }
    }
}
