package 명예의전당1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);

            while(queue.size() > k) {
                queue.poll();
            }

            answer[i] = queue.peek();
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] score = new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        Solution solution = new Solution();
        int[] answer = solution.solution(k, score);

        System.out.println(Arrays.toString(Arrays.stream(answer).toArray()));
    }
}
