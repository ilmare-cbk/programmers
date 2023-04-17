package 대충만든자판;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> letterToKeyDownCount = mappingLetterToKeyDownCount(keymap);
        return toAnswer(targets, letterToKeyDownCount);
    }

    private int[] toAnswer(String[] targets, Map<String, Integer> letterToKeyDownCount) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String[] targetLetterGroup = targets[i].split("");
            int sum = sumKeyDownCount(letterToKeyDownCount, targetLetterGroup);
            answer[i] = sum;
        }
        return answer;
    }

    private int sumKeyDownCount(Map<String, Integer> letterToKeyDownCount, String[] targetLetterGroup) {
        int sum = 0;
        for (String letter : targetLetterGroup) {
            Integer keyDownCount = letterToKeyDownCount.get(letter);
            if (keyDownCount == null) {
                sum = -1;
                break;
            }
            sum += keyDownCount;
        }
        return sum;
    }

    private Map<String, Integer> mappingLetterToKeyDownCount(String[] keymap) {
        Map<String, Integer> results = new HashMap<>();

        for (String letters : keymap) {
            String[] letterGroup = letters.split("");
            for (int i = 0; i < letterGroup.length; i++) {
                String letter = letterGroup[i];
                Integer keyDownCount = results.get(letter);
                if (keyDownCount == null) {
                    results.put(letter, i + 1);
                } else {
                    if (keyDownCount > i + 1) {
                        results.put(letter, i + 1);
                    }
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] keyMap = new String[]{"AGZ", "BSSS"};
        String[] target = new String[]{"ASA", "BGZ"};
        int[] answers = solution.solution(keyMap, target);
        System.out.println(Arrays.toString(Arrays.stream(answers).toArray()));
    }
}
