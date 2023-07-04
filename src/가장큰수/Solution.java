package 가장큰수;

import java.util.PriorityQueue;

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        PriorityQueue<String> queue =
                new PriorityQueue<>((s1, s2) -> Integer.parseInt(s2.concat(s1)) - Integer.parseInt(s1.concat(s2)));

        for (int number : numbers) {
            queue.add(String.valueOf(number));
        }

        while (!queue.isEmpty()) {
            answer = answer.concat(queue.poll());
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{0, 0};
        Solution solution = new Solution();
        String answer = solution.solution(numbers);

        System.out.println(answer);
    }
}
