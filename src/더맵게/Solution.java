package 더맵게;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville) {
            queue.add(s);
        }

        while(!queue.isEmpty() && queue.peek() < K) {
            if (queue.size() == 1 && queue.peek() < K) {
                return -1;
            }
            Integer scov1 = queue.poll();
            Integer scov2 = queue.poll();
            queue.add(scov1 + (scov2 * 2));
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = new int[]{1, 3};
        int K = 7;

        Solution solution = new Solution();
        int answer = solution.solution(scoville, K);

        System.out.println(answer);
    }
}
