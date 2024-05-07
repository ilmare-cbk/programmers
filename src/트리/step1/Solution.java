package 트리.step1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> treeMap = new HashMap<>();
    int[][] C;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(4, new int[][]{{1, 2}, {2, 3}, {2, 4}}, 3);
        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(int N, int[][] C, int T) {
        int[] answer = new int[N];
        this.C = C;
        traverseWithFindingRoot(T);
        for (int i = 1; i <= N; i++) {
            answer[i - 1] = treeMap.get(i);
        }
        return answer;
    }

    private void traverseWithFindingRoot(int T) {
        treeMap.put(T, -1);

        for (int[] ints : C) {
            if (ints[0] == T) {
                treeMap.put(ints[1], T);
                ints[0] = -1;
                traverse(ints[1]);
            } else if (ints[1] == T) {
                treeMap.put(ints[0], T);
                ints[1] = -1;
                traverse(ints[0]);
            }
        }
    }

    private void traverse(int node) {
        for (int[] ints : C) {
            if (ints[0] == -1 || ints[1] == -1) {
                continue;
            }

            if (ints[0] == node) {
                treeMap.put(ints[1], node);
                ints[0] = -1;
                traverse(ints[1]);
            }

            if (ints[1] == node) {
                treeMap.put(ints[0], node);
                ints[1] = -1;
                traverse(ints[0]);
            }
        }
    }
}
