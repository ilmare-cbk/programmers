package P84512;

import java.util.*;

/**
 * 모음 사전
 */
public class Solution {
    private static final List<String> dict = Arrays.asList("A", "E", "I", "O", "U");
    private List<String> words = new ArrayList<>();

    public int solution(String word) {
        int answer = 1;
        dfs(0, "");

        for (String s : words) {
            if (word.equals(s)) break;
            else answer++;
        }
        return answer;
    }

    private void dfs(int depth, String word) {
        if (depth == 5) {
            return;
        }

        for (String s : dict) {
            String w = word.concat(s);
            words.add(w);
            dfs(depth + 1, w);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("I"));
    }
}
