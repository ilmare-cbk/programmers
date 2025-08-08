package P42840;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 모의고사
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 4, 5})));
    }

    public int[] solution(int[] answers) {
        int[] members = new int[3];
        int[][] patterns = new int[][]{{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (patterns[j][i % (patterns[j].length)] == answers[i]) members[j]++;
            }
        }

        int maxScore = 0;
        for (int member : members) {
            maxScore = Math.max(maxScore, member);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < members.length; i++) {
            if (maxScore == members[i]) answer.add(i + 1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
