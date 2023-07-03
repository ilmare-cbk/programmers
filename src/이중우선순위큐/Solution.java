package 이중우선순위큐;

import java.util.*;

public class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reversedQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation : operations) {
            String[] operationArray = operation.split(" ");
            String command = operationArray[0];
            int operand = Integer.parseInt(operationArray[1]);

            if (command.equals("I")) {
                queue.add(operand);
                reversedQueue.add(operand);
                continue;
            }

            if (command.equals("D") && operand == -1) {
                Integer number = queue.poll();
                reversedQueue.remove(number);
                continue;
            }

            if (command.equals("D") && operand == 1) {
                Integer number = reversedQueue.poll();
                queue.remove(number);
            }

        }

        return new int[]{Optional.ofNullable(reversedQueue.peek()).orElse(0),
                Optional.ofNullable(queue.peek()).orElse(0)};
    }

    public static void main(String[] args) {
        String[] operations = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        Solution solution = new Solution();
        int[] answers = solution.solution(operations);

        System.out.println(Arrays.toString(Arrays.stream(answers).toArray()));
    }
}
