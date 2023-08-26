package 튜플;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(String s) {
        List<Integer> elements = Arrays.stream(s.replaceAll("[{}]", "").split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        Map<Integer, Integer> countByElement = new HashMap<>();

        for (Integer element : elements) {
            Integer count = countByElement.getOrDefault(element, 0);
            countByElement.put(element, count + 1);
        }

        return countByElement.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main(String[] args) {
        String s = "{{20,111},{111}}";

        Solution solution = new Solution();
        int[] answer = solution.solution(s);

        System.out.println(Arrays.toString(Arrays.stream(answer).toArray()));
    }
}
