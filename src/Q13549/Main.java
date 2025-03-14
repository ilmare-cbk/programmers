package Q13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 숨바꼭질 3
 */
public class Main {
    private static int N;
    private static int K;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        dist = new int[100001];
        for (int i = 0; i <= 100000; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dijkstra();
        System.out.println(dist[K]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[N] = 0;
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int n = node.n;
            int w = node.w;

            if (2 * n <= 100000 && dist[2 * n] > dist[n] && dist[2 * n] >= w) {
                dist[2 * n] = dist[n];
                queue.add(new Node(2 * n, w));
            }

            if (n > 0 && n <= 100000 && dist[n - 1] > dist[n] + 1 && dist[n - 1] >= w) {
                dist[n - 1] = dist[n] + 1;
                queue.add(new Node(n - 1, w + 1));
            }

            if (n < 100000 && dist[n + 1] > dist[n] + 1 && dist[n + 1] >= w) {
                dist[n + 1] = dist[n] + 1;
                queue.add(new Node(n + 1, w + 1));
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int n;
        int w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }

        public int getN() {
            return n;
        }

        public int getW() {
            return w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
