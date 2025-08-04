package P43162;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 네트워크
 */
public class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        List<Integer>[] edges = new List[n];

        for (int i = 0; i < computers.length; i++) {
            int[] computer = computers[i];
            edges[i] = new ArrayList<>();
            for (int j = 0; j < computer.length; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    edges[i].add(j);
                }
            }
        }

        for (int i = 0; i < edges.length; i++) {
            if (visited[i]) continue;
            Queue<Integer> queue = new LinkedList<>();
            visited[i] = true;
            queue.add(i);

            while (!queue.isEmpty()) {
                Integer c = queue.poll();

                List<Integer> coms = edges[c];
                for (Integer com : coms) {
                    if (!visited[com]) {
                        visited[com] = true;
                        queue.add(com);
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}
