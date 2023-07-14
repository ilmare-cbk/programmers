package 과일장수;

import java.util.Arrays;

public class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        for (int i = score.length - 1; i >= 0; i -= m) {
            if (i - m + 1 >= 0) {
                answer = answer + score[i - m + 1] * m;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int m = 4;
        int[] score = new int[]{1, 2, 3, 1, 2, 3, 1};
        // 1, 2, 3, 1, 2, 3, 1
        Solution solution = new Solution();
        int answer = solution.solution(k, m, score);

        System.out.println(answer);
    }
}
