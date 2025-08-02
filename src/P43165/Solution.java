package P43165;

import java.util.Stack;

/**
 * 타겟 넘버
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));
//        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(0, 1));

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int depth = node.depth;

            if (depth <= numbers.length) {
                stack.add(new Node(node.sum - numbers[node.depth - 1], depth + 1));
                stack.add(new Node(node.sum + numbers[node.depth - 1], depth + 1));
                continue;
            }

            if (node.sum == target) answer++;

        }
        return answer;
    }

    private static class Node {
        int sum;
        int depth;

        public Node(int sum, int depth) {
            this.sum = sum;
            this.depth = depth;
        }
    }
}
