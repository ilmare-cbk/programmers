package 귤고르기;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> tangerineByCount = new HashMap<>();
        for (int j : tangerine) {
            tangerineByCount.put(j, tangerineByCount.getOrDefault(j, 0) + 1);
        }
        List<Integer> sortedTangerines = tangerineByCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for (int i = sortedTangerines.size() - 1; i >= 0; i--) {
            Integer tangerines = sortedTangerines.get(i);
            Integer tangerineCount = tangerineByCount.get(tangerines);
            if (k <= 0) {
                break;
            }
            k -= tangerineCount;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = new int[]{1, 3, 2, 5, 4, 5, 2, 3};

        Solution solution = new Solution();
        int answer = solution.solution(k, tangerine);

        System.out.println(answer);
    }
}
