package 디스크컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int curTime = 0;
        int jobIdx = 0;
        int count = 0;

        Arrays.sort(jobs, Comparator.comparingInt(j -> j[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(j -> j[1]));

        while (count < jobs.length) {

            while (jobIdx < jobs.length && jobs[jobIdx][0] <= curTime) {
                queue.add(jobs[jobIdx++]);
            }

            if (queue.isEmpty()) {
                curTime = jobs[jobIdx][0];
            } else {
                int[] job = queue.poll();
                answer += job[1] + curTime - job[0];
                curTime += job[1];
                count++;
            }

        }

        return (int) Math.floor((double) answer / jobs.length);
    }

    public static void main(String[] args) {
        int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};

        Solution solution = new Solution();
        int answer = solution.solution(jobs);

        System.out.println(answer);
    }
}
