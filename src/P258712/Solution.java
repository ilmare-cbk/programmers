package P258712;

import java.util.HashMap;
import java.util.Map;

/**
 * 가장 많이 받은 선물
 */
public class Solution {

    private static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> friendsIndexMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendsIndexMap.put(friends[i], i);
        }
        int[][] histories = new int[friends.length][friends.length];
        int[] gIndex = new int[friends.length];
        for (int i = 0; i < gifts.length; i++) {
            String[] history = gifts[i].split(" ");
            Integer A = friendsIndexMap.get(history[0]);
            Integer B = friendsIndexMap.get(history[1]);
            histories[A][B]++;
            gIndex[A]++;
            gIndex[B]--;
        }

        int[] answers = new int[friends.length];

        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                int AB = histories[i][j];
                int BA = histories[j][i];
                if (AB > BA) answers[i]++;
                else if (BA > AB) answers[j]++;
                else {
                    int AgI = gIndex[i];
                    int Bgi = gIndex[j];
                    if (AgI > Bgi) answers[i]++;
                    else if (Bgi > AgI) answers[j]++;
                }
            }
        }

        for (int i : answers) {
            answer = Math.max(i, answer);
        }
        return answer;
    }
}
