package 구명보트;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int person : people) {
            dq.add(person);
        }

        while (!dq.isEmpty()) {
            Integer weight = dq.pollLast();
            if (!dq.isEmpty() && weight + dq.peekFirst() <= limit) {
                dq.pollFirst();
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] people = new int[]{70, 50, 80, 50};
        int limit = 100;

        Solution solution = new Solution();
        int answer = solution.solution(people, limit);

        System.out.println(answer);
    }
}
