package P258709;

import java.util.*;

/**
 * 주사위 고르기
 */
public class Solution {
    private static List<int[]> diceCombis = new ArrayList<>();
    private static int N;
    private static int[] diceCombi;
    private static int[][] dices;
    private static Map<String, Map<Integer, Integer>> scoreCache = new HashMap<>();

    public static void main(String[] args) {
        int[][] dice = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
        System.out.println(Arrays.toString(solution(dice)));
    }

    public static int[] solution(int[][] dice) {
        int[] answer = {};
        int maxWin = 0;
        dices = dice;
        N = dice.length;

        diceCombinations(1, 0);

        for (int i = 0; i < diceCombis.size() / 2; i++) {
            int bIdx = diceCombis.size() - 1 - i;
            int[] aDiceCombi = diceCombis.get(i);
            int[] bDiceCombi = diceCombis.get(bIdx);

            Map<Integer, Integer> aScoreMap = getScoreMap(aDiceCombi);
            Map<Integer, Integer> bScoreMap = getScoreMap(bDiceCombi);

            int aWin = 0;
            int bWin = 0;
            for (Integer aScore : aScoreMap.keySet()) {
                for (Integer bScore : bScoreMap.keySet()) {
                    int result = aScoreMap.get(aScore) * bScoreMap.get(bScore);
                    if (aScore > bScore) {
                        aWin += result;
                    } else if (aScore < bScore) {
                        bWin += result;
                    }
                }
            }
            if (aWin > maxWin) {
                maxWin = aWin;
                answer = aDiceCombi;
            }
            if (bWin > maxWin) {
                maxWin = bWin;
                answer = bDiceCombi;
            }
        }
        return answer;
    }

    private static void diceCombinations(int diceNum, int depth) {
        if (depth == 0) {
            diceCombi = new int[N / 2];
        }

        if (depth == N / 2) {
            diceCombis.add(Arrays.copyOf(diceCombi, N / 2));
            return;
        }

        for (int i = diceNum; i <= N; i++) {
            diceCombi[depth] = i;
            diceCombinations(i + 1, depth + 1);
        }
    }

    private static Map<Integer, Integer> getScoreMap(int[] diceCombi) {
        String key = Arrays.toString(diceCombi);
        if (scoreCache.containsKey(key)) {
            return scoreCache.get(key);
        }
        Map<Integer, Integer> scoreMap = new HashMap<>();
        score(diceCombi, 0, 0, scoreMap);
        scoreCache.put(key, scoreMap);
        return scoreMap;
    }

    private static void score(int[] diceCombi, int sum, int depth, Map<Integer, Integer> scores) {
        if (depth == N / 2) {
            scores.put(sum, scores.getOrDefault(sum, 0) + 1);
            return;
        }

        for (int i = 0; i < 6; i++) {
            int diceNum = diceCombi[depth];
            score(diceCombi, sum + dices[diceNum - 1][i], depth + 1, scores);
        }
    }
}
