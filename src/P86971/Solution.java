package P86971;

import java.util.*;

/**
 * 전력망을 둘로 나누기
 */
public class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int[] wire : wires) {
            List<Integer> nodes1 = edges.getOrDefault(wire[0], new ArrayList<>());
            nodes1.add(wire[1]);
            edges.put(wire[0], nodes1);

            List<Integer> nodes2 = edges.getOrDefault(wire[1], new ArrayList<>());
            nodes2.add(wire[0]);
            edges.put(wire[1], nodes2);
        }

        for (int[] wire : wires) {
            int cnt = bfs(wire[0], wire[1], edges);
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
        }
        return answer;
    }

    private int bfs(int cur, int broken, Map<Integer, List<Integer>> edges) {
        int searchCnt = 0;
        boolean[] visited = new boolean[edges.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);
        visited[cur] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            searchCnt++;

            List<Integer> nodes = edges.get(node);
            if (nodes == null) continue;

            for (Integer n : nodes) {
                if (n == broken) continue;
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return searchCnt;
    }
}
