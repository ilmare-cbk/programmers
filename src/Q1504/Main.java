package Q1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 특정한 최단 경로
 */
public class Main {
    private static int N, E, v1, v2;
    private static ArrayList<Node>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());
            int w = Integer.parseInt(st1.nextToken());
            edges[u].add(new Node(v, w));
            edges[v].add(new Node(u, w));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st2.nextToken());
        v2 = Integer.parseInt(st2.nextToken());

        int[] dist1 = dijkstra(1); // 1 -> v1, 1 -> v2
        int[] dist2 = dijkstra(v1); // v1 -> v2, v1 -> N
        int[] dist3 = dijkstra(v2); // v2 -> v1. v2 -> N
        int min = Math.min(getDistance(dist1[v1], dist2[v2], dist3[N]), getDistance(dist1[v2], dist3[v1], dist2[N]));
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static int getDistance(int a, int b, int c) {
        if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE || c == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return a + b + c;
    }

    private static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int v = node.v;
            int w = node.w;

            if (dist[v] < w) {
                continue;
            }

            ArrayList<Node> nodes = edges[v];
            for (Node n : nodes) {
                if (dist[n.v] > dist[v] + n.w) {
                    dist[n.v] = dist[v] + n.w;
                    queue.add(new Node(n.v, dist[n.v]));
                }
            }
        }

        return dist;
    }

    private static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
