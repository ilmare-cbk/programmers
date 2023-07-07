package 카드뭉치;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        List<String> cards1List = Arrays.stream(cards1).collect(Collectors.toList());
        List<String> cards2List = Arrays.stream(cards2).collect(Collectors.toList());

        int match = 0;

        for (String s : goal) {
            if (!cards1List.isEmpty() && cards1List.get(0).equals(s)) {
                cards1List.remove(0);
                match++;
                continue;
            }
            if (!cards2List.isEmpty() && cards2List.get(0).equals(s)) {
                cards2List.remove(0);
                match++;
            }
        }

        if (match != goal.length) {
            return "No";
        }

        return "Yes";
    }

    public static void main(String[] args) {
        String[] cards1 = new String[]{"i", "drink", "water"};
        String[] cards2 = new String[]{"want", "to"};
        String[] goal = new String[]{"i", "want", "to", "drink", "water"};

        Solution solution = new Solution();
        String answer = solution.solution(cards1, cards2, goal);

        System.out.println(answer);
    }
}
