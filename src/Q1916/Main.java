package Q1916;

import java.io.*;
import java.util.*;

/**
 * 최소비용 구하기
 */
public class Main {
    private static Map<Integer, List<Node>> info = new HashMap<>(); // 인접리스트
    private static int end;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            String[] data = br.readLine().split(" ");
            int n1 = Integer.parseInt(data[0]);
            int n2 = Integer.parseInt(data[1]);
            int d = Integer.parseInt(data[2]);
            List<Node> nodes = info.getOrDefault(n1, new ArrayList<>());
            nodes.add(new Node(n2, d));
            info.put(n1, nodes);
        }
        String[] data = br.readLine().split(" ");
        int start = Integer.parseInt(data[0]);
        end = Integer.parseInt(data[1]);
        dijkstra(start);
        System.out.println(dist[end]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.add(new Node(start, dist[start]));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (dist[node.getN()] < node.getD()) {
                continue;
            }
            List<Node> nodes = info.getOrDefault(node.getN(), new ArrayList<>());
            for (Node n : nodes) {
                if (dist[n.getN()] > dist[node.getN()] + n.getD()) {
                    dist[n.getN()] = dist[node.getN()] + n.getD();
                    queue.add(new Node(n.getN(), dist[n.getN()]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int n;
        int d;

        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }

        public int getN() {
            return n;
        }

        public int getD() {
            return d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }
}
