package Q1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 도시 분할 계획
 */
public class Main {
    private static int N, M;
    private static List<Edge>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        for (int i = 0; i < N; i++) {
            graph[i + 1] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());
            int w = Integer.parseInt(st1.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        int minWeight = 0;
        int cnt = 0;
        int maxWeight = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1, 0));

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            if (visited[e.v]) continue;

            visited[e.v] = true;
            maxWeight = Math.max(maxWeight, e.w);
            minWeight += e.w;
            cnt++;

            if (cnt == N) break;

            for (Edge edge : graph[e.v]) {
                if (!visited[edge.v]) queue.add(edge);
            }
        }
        System.out.println(minWeight - maxWeight);
    }


    private static class Edge implements Comparable<Edge> {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}
