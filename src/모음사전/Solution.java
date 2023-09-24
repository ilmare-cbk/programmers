package 모음사전;

import java.util.Arrays;
import java.util.List;

public class Solution {
    private int answer = 0;
    private List<String> dict = Arrays.asList("A", "E", "I", "O", "U");
    
    public int solution(String word) {
        String currentWord = "";
        while (!word.equals(currentWord)) {
            currentWord = next(currentWord);
        }
        return answer;
    }

    private String next(String word) {
        answer++;
        if (word.length() < 5) {
            return word + dict.get(0);
        }
        
        String[] split = word.split("");
        int uIndex = word.length() - 1;
        while (split[uIndex].equals(dict.get(dict.size() - 1))) {
            uIndex--;
        }

        int characterIndexForChange = dict.indexOf(split[uIndex]);
        return word.substring(0, uIndex) + dict.get(characterIndexForChange + 1);
    }

    public static void main(String[] args) {
        String word = "EIO";

        Solution solution = new Solution();
        int answer = solution.solution(word);

        System.out.println(answer);
    }
}
