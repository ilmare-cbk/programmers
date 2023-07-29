package 짝지어제거하기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(String s) {
        String[] chars = s.split("");
        List<String> stack = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                stack.add(chars[i]);
            } else {
                if (!stack.isEmpty() && stack.get(stack.size() - 1).equals(chars[i])) {
                    stack.remove(stack.size() - 1);
                } else {
                    stack.add(chars[i]);
                }
            }

        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        String s = "baabaa";
        Solution solution = new Solution();
        int answer = solution.solution(s);

        System.out.println(answer);
    }
}
