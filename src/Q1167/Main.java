package Q1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리의 지름
 */
public class Main {
    private static int V;
    private static List<Node>[] edges;
    private static int farthestNode;
    private static boolean[] visited;
    private static int maxDist = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        edges = new List[V + 1];
        visited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) {
                    break;
                }
                int w = Integer.parseInt(st.nextToken());
                edges[u].add(new Node(v, w));
            }
        }

        dfs(1, 0);

        maxDist = Integer.MIN_VALUE;
        Arrays.fill(visited, false);
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

    private static void dfs(int node, int dist) {
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }

        visited[node] = true;

        List<Node> nodes = edges[node];
        for (Node n : nodes) {
            if (!visited[n.v]) {
                dfs(n.v, dist + n.w);
            }
        }
    }

    private static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
