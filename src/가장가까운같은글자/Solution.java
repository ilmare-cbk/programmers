package 가장가까운같은글자;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<String, Integer> idxByLetter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String letter = s.substring(i, i + 1);
            Integer idx = idxByLetter.getOrDefault(letter, -1);
            idxByLetter.put(letter, i);

            if (idx < 0) {
                answer[i] = idx;
            } else {
                answer[i] = i - idx;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "banana";
        Solution solution = new Solution();
        int[] answer = solution.solution(s);

        System.out.println(Arrays.toString(Arrays.stream(answer).toArray()));
    }
}
