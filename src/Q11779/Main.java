package Q11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최소비용 구하기 2
 */
public class Main {
    private static int n;
    private static int m;
    private static PriorityQueue<Node> queue = new PriorityQueue<>();
    private static List<Node>[] edges;
    private static int[] dist;
    private static int[] route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        edges = new List[n + 1];
        dist = new int[n + 1];
        route = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Node(v, w));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        dijkstra(s);
        List<Integer> path = new ArrayList<>();
        for (int i = d; i != 0; i = route[i]) path.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[d]).append(System.lineSeparator());
        sb.append(path.size()).append(System.lineSeparator());
        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        dist[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int v = node.v;
            int w = node.w;

            if (dist[v] < w) {
                continue;
            }

            List<Node> nodes = edges[v];
            for (Node n : nodes) {
                if (dist[n.v] > dist[v] + n.w) {
                    dist[n.v] = dist[v] + n.w;
                    route[n.v] = v;
                    queue.add(new Node(n.v, dist[n.v]));
                }
            }
        }
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
