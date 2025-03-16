package Q1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최단경로
 */
public class Main {
    private static int V;
    private static int E;
    private static Map<Integer, List<Node>> nodeMap = new HashMap<>();
    private static int s;
    private static PriorityQueue<Node> queue = new PriorityQueue<>();
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        s = Integer.parseInt(br.readLine());
        dist = new int[V + 1];

        for (int i = 0; i < E; i++) {
            String[] data = br.readLine().split(" ");
            int u = Integer.parseInt(data[0]);
            int v = Integer.parseInt(data[1]);
            int w = Integer.parseInt(data[2]);
            List<Node> nodes = nodeMap.getOrDefault(u, new ArrayList<>());
            nodes.add(new Node(v, w));
            nodeMap.put(u, nodes);
        }
        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append(System.lineSeparator());
            } else {
                sb.append(dist[i]).append(System.lineSeparator());
            }
        }
        System.out.println(sb);
    }

    private static void dijkstra() {
        queue.add(new Node(s, 0));
        dist[s] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int v = node.v;
            int w = node.w;
            List<Node> nodes = nodeMap.getOrDefault(v, new ArrayList<>());
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
