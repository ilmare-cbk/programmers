package 추억점수;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        List<String> nameList = Arrays.asList(name);

        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (String target : photo[i]) {
                int nameIdx = findNameIdx(nameList, target);
                score += findScore(nameIdx, yearning);
            }
            answer[i] = score;
        }

        return answer;
    }

    private int findScore(int idx, int[] yearning) {
        if (idx < 0) {
            return 0;
        }

        return yearning[idx];
    }

    private static int findNameIdx(List<String> nameList, String target) {
        return nameList.indexOf(target);
    }
}
