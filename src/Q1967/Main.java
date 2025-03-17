package Q1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 트리의 지름
 */
public class Main {
    private static int n;
    private static int m_v = 0; // 각 이터레이션에서 최대 지름을 결정하는 정점
    private static List<Node>[] nodeMap;
    private static boolean[] visited;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        nodeMap = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            nodeMap[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodeMap[u].add(new Node(v, w));
            nodeMap[v].add(new Node(u, w));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        Arrays.fill(visited, false);
        dfs(m_v, 0);

        System.out.println(answer);
    }

    private static void dfs(int s, int d) {
        visited[s] = true;

        List<Node> nodes = nodeMap[s];
        for (Node node : nodes) {
            int v = node.v;
            int w = node.w;
            if (!visited[v]) {
                dfs(v, d + w);
            }
        }

        if (d > answer) {
            answer = d;
            m_v = s;
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
