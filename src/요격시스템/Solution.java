package 요격시스템;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int answer = 1;
        int[] currentTarget = targets[0];
        for (int[] target : targets) {
            if (isOverlap(currentTarget, target)) {
                currentTarget = overlap(currentTarget, target);
                continue;
            }
            currentTarget = target;
            answer++;
        }
        return answer;
    }

    private boolean isOverlap(int[] currentTarget, int[] target) {
        return currentTarget[1] > target[0];
    }

    private int[] overlap(int[] currentTarget, int[] target) {
        int s = Math.max(currentTarget[0], target[0]);
        int e = Math.min(currentTarget[1], target[1]);

        return new int[]{s, e};
    }

    public static void main(String[] args) {
        int[][] targets = new int[][]{{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        Solution solution = new Solution();
        int answer = solution.solution(targets);
        System.out.println(answer);
    }
}
