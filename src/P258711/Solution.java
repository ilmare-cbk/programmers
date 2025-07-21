package P258711;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] edges =
//                {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
                {{2,1}};
        System.out.println(Arrays.toString(solution(edges)));
    }

    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];
        boolean[] visited = new boolean[1_000_001];
        boolean[] parents = new boolean[1_000_001];
        Map<Integer, List<Integer>> edges2 = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> nodes = edges2.getOrDefault(edge[0], new ArrayList<>());
            nodes.add(edge[1]);
            edges2.put(edge[0], nodes);
            List<Integer> nodes2 = edges2.getOrDefault(edge[1], new ArrayList<>());
            edges2.put(edge[1], nodes2);
            parents[edge[1]] = true;
        }

        /**
         * 생성한 정점 찾기 (나가는 간선이 최소 2개인 정점 && 들어오는 간선이 없음)
         */
        for (Map.Entry<Integer, List<Integer>> entry : edges2.entrySet()) {
            if (entry.getValue().size() < 2) continue;
            if (!parents[entry.getKey()]) {
                answer[0] = entry.getKey();
                break;
            }
        }

        /**
         * 도넛/막대/8자 그래프 찾기
         */
        for (Integer node : edges2.get(answer[0])) {
            List<Integer> nodes = edges2.get(node);
            visited[node] = true;
            while (true) {
                if (nodes.size() == 2) {
                    answer[3]++; // 8자 그래프
                    break;
                }
                if (nodes.isEmpty()) {
                    answer[2]++; // 막대 그래프
                    break;
                }
                if (!visited[nodes.get(0)]) {
                    visited[nodes.get(0)] = true;
                    nodes = edges2.get(nodes.get(0));
                } else {
                    answer[1]++;
                    break;
                }
            }
        }

        return answer;
    }
}
