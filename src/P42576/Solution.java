package P42576;

import java.util.HashMap;
import java.util.Map;

/**
 * 완주하지 못한 선수
 */
public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> cntByParticipant = new HashMap<>();
        for (String c : completion) {
            cntByParticipant.put(c, cntByParticipant.getOrDefault(c, 0) + 1);
        }

        for (String p : participant) {
            if (cntByParticipant.getOrDefault(p, 0) == 0) {
                answer = p;
                break;
            } else {
                cntByParticipant.put(p, cntByParticipant.get(p) - 1);
            }
        }
        return answer;
    }
}
