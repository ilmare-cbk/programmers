package 영어끝말잇기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        List<String> usedWords = new ArrayList<>();
        usedWords.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) || usedWords.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            usedWords.add(words[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        String[] words = new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        Solution solution = new Solution();
        int[] answer = solution.solution(n, words);

        System.out.println(Arrays.toString(Arrays.stream(answer).toArray()));
    }
}
