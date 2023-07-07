package 둘만의암호;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        List<Integer> ascii = new ArrayList<>();
        for (String s1 : skip.split("")) {
            ascii.add((int) s1.charAt(0));
        }

        for (int i = 0; i < s.length(); i++) {
            int indexCount = 0;
            char letter = s.charAt(i);

            while (indexCount < index) {

                if (letter + 1 > 122) {
                    letter = (char) (97 + (letter - 123));
                }

                if (!ascii.contains(letter + 1)) {
                    indexCount++;
                }

                letter = (char) (letter + 1);
            }

            answer = answer.concat(String.valueOf(letter));
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        Solution solution = new Solution();
        String answer = solution.solution(s, skip, index);

        System.out.println(answer);

    }
}
