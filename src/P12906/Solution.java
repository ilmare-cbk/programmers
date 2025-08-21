package P12906;

import java.util.Arrays;
import java.util.Stack;

/**
 * 같은 숫자는 싫어
 */
public class Solution {
    public int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.add(arr[i]);
            } else {
                int n = stack.peek();
                if (n != arr[i]) {
                    stack.add(arr[i]);
                }
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                Arrays.toString(solution.solution(new int[]{1, 1, 3, 3, 0, 1, 1}))
        );
    }
}
