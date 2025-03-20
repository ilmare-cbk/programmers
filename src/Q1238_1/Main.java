package Q1238_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 파티 (다익스트라 버전)
 */
public class Main {
    private static int N;
    private static int M;
    private static int X;
    private static List<Node>[] graph;
    private static List<Node>[] reversedGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        reversedGraph = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reversedGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer data = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(data.nextToken());
            int b = Integer.parseInt(data.nextToken());
            int t = Integer.parseInt(data.nextToken());
            graph[a].add(new Node(b, t));
            reversedGraph[b].add(new Node(a, t));
        }

        int[] dist1 = dijkstra(X, graph);
        int[] dist2 = dijkstra(X, reversedGraph);
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dist1[i] + dist2[i]);
        }
        System.out.println(answer);
    }

    private static int[] dijkstra(int x, List<Node>[] graph) {
        int[] dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(x, 0));
        dist[x] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int v = node.v;
            int w = node.w;

            List<Node> nodes = graph[v];
            for (Node n : nodes) {
                if (dist[n.v] <= w) {
                    continue;
                }
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
