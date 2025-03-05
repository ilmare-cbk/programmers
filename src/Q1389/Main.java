package Q1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 케빈 베이컨의 6단계 법칙
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < M; i++) {
            String[] n = br.readLine().split(" ");
            int n1 = Integer.parseInt(n[0]);
            int n2 = Integer.parseInt(n[1]);

            List<Integer> nodes1 = graph.getOrDefault(n1, new ArrayList<>());
            nodes1.add(n2);
            graph.put(n1, nodes1);

            List<Integer> nodes2 = graph.getOrDefault(n2, new ArrayList<>());
            nodes2.add(n1);
            graph.put(n2, nodes2);
        }

        int distance = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            int[] depth = new int[N + 1];

            int result = bfs(graph, i, visited, depth);
            if (distance > result) {
                distance = result;
                answer = i;
            }
        }

        System.out.println(answer);
    }

    private static int bfs(Map<Integer, List<Integer>> graph, int start, boolean[] visited, int[] depth) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        int answer = 0;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (Integer next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    depth[next] = depth[node] + 1;
                    answer += depth[next];
                }
            }
        }


        return answer;
    }
}
